package com.visilean.aopdemo.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.visilean.aopdemo.entity.Account;

@Repository
public class AccountDAOImpl implements AccountDAO {
	
	private String name;
	private String serviceName;

	@Override
	public void addAccount(Account acc, boolean vipFlag) {
		System.out.println(getClass() + " : Doing my DB work : Adding an account");
	}

	@Override
	public boolean doWork() {
		System.out.println(getClass() + " : doWork() Method");
		return false;
	}
	
	
	public String getName() {
		System.out.println(getClass() + " inside of getName() Method");
		return name;
	}
	
	public void setName(String name) {
		System.out.println(getClass() + " inside of setName() Method");
		this.name = name;
	}
	
	public String getServiceName() {
		System.out.println(getClass() + " inside of getServiceName() Method");
		return serviceName;
	}
	
	public void setServiceName(String serviceName) {
		System.out.println(getClass() + " inside of setServiceName() Method");
		this.serviceName = serviceName;
	}

	@Override
	public List<Account> findAccounts() {
		return findAccounts(false);
	}

	@Override
	public List<Account> findAccounts(boolean tripWire) {
		
		// for learning throwing an exception
		if(tripWire == true) {
			throw new RuntimeException("Ohhh NO... Ohhh NO... Ohhh NO NO NO NO NO");
		}
		
		List<Account> myAccounts = new ArrayList<Account>();
		
		// create sample accounts
		Account temp1 = new Account("Adnan", "Platinum");
		Account temp2 = new Account("Abhay", "Gold");
		Account temp3 = new Account("Harsh", "Silver");
		
		// add them to the list
		
		myAccounts.add(temp1);
		myAccounts.add(temp2);
		myAccounts.add(temp3);
		
		return myAccounts;
	}

}
