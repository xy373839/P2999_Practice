package cn.xy.service.impl;

import cn.xy.bean.Account;
import cn.xy.dao.AccountDao;
import cn.xy.service.AccountService;

public class AccountServiceImpl implements AccountService {

	private AccountDao accoutDao;

	public void setAccoutDao(AccountDao accoutDao) {
		this.accoutDao = accoutDao;
	}

	@Override
	public Account findAccountById(Integer id) {

		return accoutDao.findAccountById(id);

	}

	@Override
	public Account findAccountByName(String name) {

		return accoutDao.findAccountByName(name);
	}

	@Override
	public void updateAccount(Account account) {
		accoutDao.updateAccount(account);

	}

	@Override
	public void transfer(String sourceName, String targetName, Float money) {
		System.out.println("transfer开始执行");
		Account source = accoutDao.findAccountByName(sourceName);
		Account target = accoutDao.findAccountByName(targetName);
		if (source.getMoney() - money > 0) {
			source.setMoney(source.getMoney() - money);
			target.setMoney(target.getMoney() + money);
			accoutDao.updateAccount(source);
//			 int aa=5/0;
			accoutDao.updateAccount(target);
		} else if (source.getMoney() - money < 0) {
			throw new RuntimeException("余额不足");
		}

	}

}
