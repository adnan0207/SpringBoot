package com.visilean.aopdemo.dao;

import org.springframework.stereotype.Repository;

@Repository
public class MembershipDAOImpl implements MembershipDAO {

	@Override
	public boolean addMember() {
		System.out.println(getClass() + " : Doing my DB work : Adding a membership account");
		return true;
	}

	@Override
	public void goToSleep() {
		System.out.println(getClass() + " : I am going to sleep now.....");
	}

}
