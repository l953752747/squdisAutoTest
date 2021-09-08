package com.duoyun.suqids.autotest.ui.squdisautotest.pageObject.squdisPageObject.impl;

import com.duoyun.suqids.autotest.ui.squdisautotest.driver.selenide.Actions;
import com.duoyun.suqids.autotest.ui.squdisautotest.pageObject.squdisPageObject.SquidsPage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class SquidsPageImpl implements SquidsPage {
    private final static String loginBrowserElement = "//*[@class='topbars__nav']/ul/li[4]/a/button";
    private final static String emailElement = "input#email";
    private final static String passWordElement = "input#password";
    private final static String buttonElement = "//*[@class='col-5']//button";

    @Autowired
    Actions actions;

    public void clickLoginBrowser() {
        actions.click(loginBrowserElement, "xpath");
    }


    public void inputEmail() {
        actions.input(emailElement, "l123456", "css");
        actions.pause(1000);
    }


    public void inputPassword() {
        actions.input(passWordElement, "123456", "css");
        actions.pause(1000);
    }

    public void clickLoginButton() {
        actions.click(buttonElement, "xpath");

    }
}
