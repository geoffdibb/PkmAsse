package com.BAE.PersistenceTests;

import org.junit.Test;

import com.BAE.domain.Account;

import junit.framework.Assert;

public class PersistenceTests {
	Account acc = new Account(2, "Zilla", "Zilla");

	@Test
	public void testGetteruserName() {

		Assert.assertEquals(acc.getuserName(), "Zilla");
	}

	@Test
	public void testSetuserName() {
		acc.setuserName("Zilla");
		Assert.assertEquals(acc.getuserName(), "Zilla");
	}
}