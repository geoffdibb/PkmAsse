package com.BAE.service;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit4.SpringRunner;

import com.BAE.domain.Account;
import com.BAE.respository.AccountRepository;
@RunWith(SpringRunner.class)
public class MockitoTest {
	@InjectMocks
	AccountServiceImpl service;
	
	@Mock
	AccountRepository repo;
	
	private static final Account fakeaccount1 = new Account(1, "Kevin", "Mcfreedom");
	private static final Account fakeaccount2 = new Account(2, "Mike", "Chowda");
	
	@Test
	public void findAllTest() {
		List<Account> fakelist = new ArrayList<>();
		fakelist.add(fakeaccount1);
		fakelist.add(fakeaccount2);
		Mockito.when(repo.findAll()).thenReturn(fakelist);
		assertEquals(fakelist, service.findAll());
		Mockito.verify(repo).findAll();
	}
	

	

}