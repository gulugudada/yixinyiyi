package com.yixinyiyi.dao;

import com.yixinyiyi.entity.Account;
import com.yixinyiyi.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface AccountMapper {
    public List<Account> findAllAccount();
    public Account findAccountByAccount(String account);
    public User findUserByUserName(String username);
    public int findAccountIsUse(String account);
    public int findUserNameIsUse(String username);
    public String findPassWordByAccount(String account);
    public int addAccount(Account account);
    public int addUser(User user);
    public int updateAccount(Account account);
    public int updateUser(User user);
}
