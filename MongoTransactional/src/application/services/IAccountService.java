package application.services;

import java.util.List;
import application.documents.Account;

public interface IAccountService {
	
	Account getAccount(int id);
	Account addAccount(int id, int balance);
	List<Account> transfer(int idFrom, int idTo, int amount);
	List<Account> getAllAccounts();
	
	Account grantAmount (int id, int amount);

}
