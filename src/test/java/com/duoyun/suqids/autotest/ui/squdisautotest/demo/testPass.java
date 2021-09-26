package com.duoyun.suqids.autotest.ui.squdisautotest.demo;

import com.duoyun.suqids.autotest.ui.squdisautotest.SqudisAutoTestApplicationTests;
import com.duoyun.suqids.autotest.ui.squdisautotest.pageObject.squdisPageObject.CreateDataBasePage;
import com.duoyun.suqids.autotest.ui.squdisautotest.pageObject.squdisPageObject.SquidsPage;
import com.duoyun.suqids.autotest.ui.squdisautotest.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.Test;

public class testPass extends SqudisAutoTestApplicationTests {


    @Autowired
    private SquidsPage squidsPage;

    @Autowired
    private LoginService loginService;

    @Autowired
    private CreateDataBasePage dataBasePage;

//    @Test
//    public void test01(){
//        System.out.println(dataMocker.browser);
//    }

    @Test
    public void loginPass(){
        loginSquids();
        squidsPage.clickSslConnect();
        squidsPage.clickUrlClick();
        squidsPage.clickLoginBrowser();
        squidsPage.inputEmail();
        squidsPage.inputPassword();
        squidsPage.clickLoginButton();
    }
    @Test
    public void createDataBase(){
        loginPass();
        System.out.println("sss");
        dataBasePage.clickCreateDataBase();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    private void loginSquids(){
        loginService.loginSquids();
    }
}
