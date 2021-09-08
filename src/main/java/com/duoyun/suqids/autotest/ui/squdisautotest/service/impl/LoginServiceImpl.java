package com.duoyun.suqids.autotest.ui.squdisautotest.service.impl;

import com.duoyun.suqids.autotest.ui.squdisautotest.pageObject.loginPageObject.LoginPage;
import com.duoyun.suqids.autotest.ui.squdisautotest.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {
    public LoginServiceImpl(){}
    @Autowired
    LoginPage loginPage;
    public void loginSquids() {
        loginPage.loginSquids();
    }
}
