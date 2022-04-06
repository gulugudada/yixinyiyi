package com.yixinyiyi.service;

import com.yixinyiyi.entity.Account;
import com.yixinyiyi.entity.User;

import java.util.List;

public interface AccountService {
    public List<Account> findAllAccount();
    public Account findAccountByAccount(String account);
    public User findUserByUserName(String username);
    public boolean findAccountIsUse(String account);
    public boolean findUserNameIsUse(String username);
    public String findPassWordByAccount(String account);
    public boolean addAccount(Account account);
    public boolean updateAccount(Account account);
    public boolean updateUser(User user);
}
