package cn.xy.service;

import cn.xy.bean.Account;

public interface AccountService {

	public Account findAccountById(Integer id);

	public Account findAccountByName(String name);

	public void updateAccount(Account account);

	public void transfer(String sourceName, String targetName, Float money);

}
