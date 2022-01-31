package application.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import application.documents.Account;
import application.services.IAccountService;

@RestController
public class AccountController {
	
	@Autowired IAccountService service;
	
	@GetMapping("/getAccount")
	public Account getAccount(int id) {
		return service.getAccount(id);
	}
	
	@PostMapping("/addAccount")
	public Account addAccount(int id, int balance) {
		return service.addAccount(id, balance);
	}
	
	@PutMapping("/transferAmount")
	public List<Account> transferAmount(int idFrom, int idTo, int amount){
		return service.transfer(idFrom, idTo, amount);
	}
	
	@GetMapping("/allAccounts")
	public List<Account> allAccounts(){
		return service.getAllAccounts();
	}
	
	@PutMapping("/grantAmount")
	public Account grantAmount(int id, int amount) {
		return service.grantAmount(id, amount);
	}
}
