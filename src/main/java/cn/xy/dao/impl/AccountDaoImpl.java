package cn.xy.dao.impl;

import java.util.List;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import cn.xy.bean.Account;
import cn.xy.dao.AccountDao;

public class AccountDaoImpl extends JdbcDaoSupport implements AccountDao {

	@Override
	public Account findAccountById(Integer id) {

		List<Account> accounts = getJdbcTemplate().query("select * from account where id=?",
				new BeanPropertyRowMapper<Account>(Account.class), id);

		return accounts == null ? null : accounts.get(0);
	}

	@Override
	public Account findAccountByName(String name) {
		List<Account> accounts = getJdbcTemplate().query("select * from account where name=?",
				new BeanPropertyRowMapper<Account>(Account.class), name);

		if (accounts.isEmpty()) {
			return null;
		}
		if (accounts.size() > 1) {
			throw new RuntimeException("结果不唯一。");
		}
		return accounts.get(0);

	}

	@Override
	public void updateAccount(Account account) {

		getJdbcTemplate().update("update account set name=? ,money =? where id=?", account.getName(),
				account.getMoney(), account.getId());

	}

}
