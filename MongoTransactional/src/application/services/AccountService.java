package application.services;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import application.documents.Account;
import application.repositories.AccountMongoRepsitory;

@Service
@Transactional
public class AccountService implements IAccountService{
	
	@Autowired AccountMongoRepsitory accountRepo;
	
	@Override
	public Account getAccount(int id) {
		Account account = accountRepo.findById(id)
				                     .orElseThrow(() ->new AccountDemoException("Account with id " + id + " doesn't exist"));
		return account;
	}
	
	@Override
	public Account addAccount(int id, int balance) {
		if (accountRepo.existsById(id))
			throw new AccountDemoException("Account with id " + id + " already exists");
		Account account = new Account(id, balance);
		accountRepo.save(account);
		return account;
	}
	
	private Account addAmount(int id, int amount) {

		Account account = getAccount(id);
		account.setBalance(account.getBalance() + amount);
		accountRepo.save(account);
		return account;
	}

	@Override
	public List<Account> transfer(int idFrom, int idTo, int amount) {
		
		Account from = addAmount(idFrom, -amount) ;
		Account to = addAmount(idTo, amount);
		
		Account[] accounts = {from, to};
		return Arrays.asList(accounts);
	}

	@Override
	public List<Account> getAllAccounts() {
		return accountRepo.findAll();
	}

	@Override
	public Account grantAmount(int id, int amount) {
		Account account = getAccount(id);
		account.setBalance(account.getBalance() + amount);
		//accountRepo.save(account);
		return account;
	}	
}
