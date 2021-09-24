package com.duoyun.suqids.autotest.ui.squdisautotest.pageObject.squdisPageObject.impl;

import com.duoyun.suqids.autotest.ui.squdisautotest.driver.selenide.Actions;
import com.duoyun.suqids.autotest.ui.squdisautotest.pageObject.squdisPageObject.SquidsPage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class SquidsPageImpl implements SquidsPage {
    private final static String sslConnectElement = "//*[@class='nav-wrapper']/button[3]";
    private final static String urlClickElement = "a#proceed-link";
    private final static String loginBrowserElement = "//*[@class='topbars__nav']/ul/li[4]/a/button";
    private final static String emailElement = "input#email";
    private final static String passWordElement = "input#password";
    private final static String buttonElement = "//*[@class='col-5']//button";

    @Autowired
    Actions actions;

    public void clickSslConnect(){
        actions.click(sslConnectElement,"xpath");
    }

    public void clickUrlClick(){
        actions.click(urlClickElement,"css");
    }

    public void clickLoginBrowser() {
        actions.click(loginBrowserElement, "xpath");
    }


    public void inputEmail() {
        actions.input(emailElement, "leiliu", "css");
        actions.pause(1000);
    }


    public void inputPassword() {
        actions.input(passWordElement, "qwer123", "css");
        actions.pause(1000);
    }

    public void clickLoginButton() {
        actions.click(buttonElement, "xpath");
    }
}
