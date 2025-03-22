package com.visilean.aopdemo.dao;

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

}
