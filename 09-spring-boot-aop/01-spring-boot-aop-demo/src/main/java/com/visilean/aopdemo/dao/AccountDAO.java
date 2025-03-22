package com.visilean.aopdemo.dao;

import com.visilean.aopdemo.entity.Account;

public interface AccountDAO {
	
	public void addAccount(Account acc, boolean vipFlag);
	
	public boolean doWork();
	
	public String getName();
	
	public void setName(String name);
	
	public String getServiceName();
	
	public void setServiceName(String serviceName);

}
