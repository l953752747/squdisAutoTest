package com.duoyun.suqids.autotest.ui.squdisautotest.demo;

import com.duoyun.suqids.autotest.ui.squdisautotest.SqudisAutoTestApplicationTests;
import com.duoyun.suqids.autotest.ui.squdisautotest.dataprovider.DataMocker;
import com.duoyun.suqids.autotest.ui.squdisautotest.pageObject.squdisPageObject.SquidsPage;
import com.duoyun.suqids.autotest.ui.squdisautotest.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.Test;

public class testPass extends SqudisAutoTestApplicationTests {
    @Autowired
    private DataMocker dataMocker;

    @Autowired
    private SquidsPage squidsPage;

    @Autowired
    private LoginService loginService;

    @Test
    public void test01(){
        System.out.println(dataMocker.browser);
    }

    @Test
    public void loginPass(){
        loginSquids();
        squidsPage.clickLoginBrowser();
        squidsPage.inputEmail();
        squidsPage.inputPassword();
        squidsPage.clickLoginButton();
    }
    private void loginSquids(){
        loginService.loginSquids();
    }
}
