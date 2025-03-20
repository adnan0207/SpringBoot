package com.visilean.aopdemo.dao;

import org.springframework.stereotype.Repository;

import com.visilean.aopdemo.entity.Account;

@Repository
public class AccountDAOImpl implements AccountDAO {

	@Override
	public void addAccount(Account acc, boolean vipFlag) {
		System.out.println(getClass() + " : Doing my DB work : Adding an account");
	}

	@Override
	public boolean doWork() {
		System.out.println(getClass() + " : doWork() Method");
		return false;
	}

}
