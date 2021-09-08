package com.duoyun.suqids.autotest.ui.squdisautotest.pageObject.loginPageObject.impl;


import com.duoyun.suqids.autotest.ui.squdisautotest.driver.selenide.Actions;
import com.duoyun.suqids.autotest.ui.squdisautotest.pageObject.loginPageObject.LoginPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class LoginPageImpl implements LoginPage {
    @Autowired
    Actions actions;

    public void loginSquids() {
        String url = "https://test.squids.io";
        actions.openUrl(url);

    }
}
