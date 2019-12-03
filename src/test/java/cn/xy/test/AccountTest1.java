package cn.xy.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.xy.service.AccountService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(value = "classpath:spring.xml")
public class AccountTest1 {
	
	@Autowired
	private AccountService as;

	@Test
	public void testTransfer() {
		as.transfer("aaa", "bbb", 100f);
		System.out.println("转账结束");
	}
}
