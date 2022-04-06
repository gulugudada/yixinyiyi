package com.yixinyiyi.controller;

import com.yixinyiyi.entity.Account;
import com.yixinyiyi.entity.User;
import com.yixinyiyi.service.AccountService;
import com.yixinyiyi.utils.Result;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Date;

@Api(tags="登录类")
@RestController
@CrossOrigin
public class AccountController {

    @Autowired
    AccountService accountService;

    @PostMapping("findAllAccount")
    public Result findAllAccount(){
        return Result.ok(accountService.findAllAccount());
    }

    @PostMapping("findAccountByAccount")
    public Result findAccountByAccount(String account){
        account = account.replace("\"","");
        Account account1 = accountService.findAccountByAccount(account);
        if(account1 != null){
            return Result.ok(account1);
        }
        return Result.error(-1,"该账号未注册！");
    }

    @PostMapping("findPassWordByAccount")
    public Result findPassWordByAccount(String account,String password){
        account = account.replace("\"","");
        password = password.replace("\"","");
        if(!accountService.findAccountIsUse(account)){
            return Result.error(-1,"该账号未注册");
        }
        else if(accountService.findPassWordByAccount(account).equals(password)){
            Result result = new Result();
            result.put("msg","登录成功");
            return result;
        }
        else{
            return Result.error(-1,"密码错误");
        }
    }

    @PostMapping("addAccount")
    public Result addAccount(String account,String username,String password){
        account = account.replace("\"","");
        username = username.replace("\"","");
        password = password.replace("\"","");
        if (!accountService.findAccountIsUse(account)) {
            if (!accountService.findUserNameIsUse(username)) {
                Account account1 = new Account();
                account1.setAccount(account);
                account1.setUsername(username);
                account1.setPassword(password);
                if (accountService.addAccount(account1)) {
                    return Result.ok("注册成功");
                }
            }
            return Result.error(-1, "该用户名已被使用");
        }
        return Result.error(-1, "该账号已被使用");
    }

    @PostMapping("updateAccount")
    public Result updateAccount(String account,String username,String password){
        account = account.replace("\"","");
        username = username.replace("\"","");
        password = password.replace("\"","");
        if(!accountService.findUserNameIsUse(username)){
            Account account1 = new Account();
            account1.setAccount(account);
            account1.setUsername(username);
            account1.setPassword(password);
            if(accountService.updateAccount(account1)){
                return Result.ok("更新成功");
            }
        }
        return Result.error(-1,"该用户名已被使用");
    }

    @PostMapping("findUserByAccount")
    public Result findUserByAccount(String account){
        account = account.replace("\"","");
        Account account1 = accountService.findAccountByAccount(account);
        return Result.ok(accountService.findUserByUserName(account1.getUsername()));
    }

    @PostMapping("updateUser")
    public Result updateUser(String username,String sex,String birthday,String school,String location){
        username = username.replace("\"","");
        sex = sex.replace("\"","");
        System.out.println(sex);
        birthday = birthday.replace("\"","");
        school = school.replace("\"","");
        location = location.replace("\"","");
        User user = new User();
        user.setUsername(username);
        user.setSex(sex);
        user.setBirthday(Date.valueOf(birthday));
        System.out.println(school);
        user.setSchool(school.split("大学")[0]+"大学");
        user.setGrade(school.split("大学")[1].split("级")[0]+"级");
        user.setCollege(school.split("大学")[1].split("级")[1].split("学院")[0]+"学院");
        user.setAdministrativeclass(school.split("学院")[1]);
        user.setLocation(location);
        return Result.ok(user);
    }
}
