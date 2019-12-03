package cn.xy.dao;

import cn.xy.bean.Account;

public interface AccountDao {

	public Account findAccountById(Integer id);

	public Account findAccountByName(String name);

	public void updateAccount(Account account);
}
