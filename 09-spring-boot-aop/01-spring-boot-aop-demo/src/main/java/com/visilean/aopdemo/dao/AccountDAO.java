package com.visilean.aopdemo.dao;

import com.visilean.aopdemo.entity.Account;

public interface AccountDAO {
	
	public void addAccount(Account acc, boolean vipFlag);

}
