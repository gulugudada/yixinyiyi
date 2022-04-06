package com.yixinyiyi.service.impl;

import com.yixinyiyi.dao.AccountMapper;
import com.yixinyiyi.entity.Account;
import com.yixinyiyi.entity.User;
import com.yixinyiyi.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;
@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    AccountMapper accountMapper;

    @Override
    public List<Account> findAllAccount() {
        return accountMapper.findAllAccount();
    }

    @Override
    public Account findAccountByAccount(String account) {
        return accountMapper.findAccountByAccount(account);
    }

    @Override
    public User findUserByUserName(String username) {
        return accountMapper.findUserByUserName(username);
    }

    @Override
    public boolean findAccountIsUse(String account) {
        if(accountMapper.findAccountIsUse(account) > 0){
            return true;
        }
        return false;
    }

    @Override
    public boolean findUserNameIsUse(String username) {
        if(accountMapper.findUserNameIsUse(username) > 0){
            return true;
        }
        return false;
    }

    @Override
    public String findPassWordByAccount(String account) {
        return accountMapper.findPassWordByAccount(account);
    }

    @Override
    public boolean addAccount(Account account) {
        if(accountMapper.addAccount(account) > 0){
            User user = new User();
            user.setUsername(account.getUsername());
            user.setBirthday(Date.valueOf("2001-01-01"));
            user.setSchool("大学");
            user.setCollege("学院");
            user.setGrade("2019级");
            user.setAdministrativeclass("班");
            user.setLocation("省市");
            user.setGeqian("没什么好说的");
            user.setTouxiang("image/touxiang/lalala.jpg");
            accountMapper.addUser(user);
            return true;
        }
        return false;
    }

    @Override
    public boolean updateAccount(Account account) {
        if(accountMapper.updateAccount(account) > 0){
            return true;
        }
        return false;
    }

    @Override
    public boolean updateUser(User user) {
        if(accountMapper.updateUser(user) > 0){
            return true;
        }
        return false;
    }
}
