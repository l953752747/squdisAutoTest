package com.duoyun.suqids.autotest.ui.squdisautotest;


import com.duoyun.suqids.autotest.ui.squdisautotest.dataprovider.login.LoginFactory;
import com.duoyun.suqids.autotest.ui.squdisautotest.driver.selenide.Actions;
import com.duoyun.suqids.autotest.ui.squdisautotest.driver.selenium.SeleActions;
import com.duoyun.suqids.autotest.ui.squdisautotest.listeners.CaseListener;


import com.duoyun.suqids.autotest.ui.squdisautotest.pageObject.squdisPageObject.CreateDataBasePage;
import com.duoyun.suqids.autotest.ui.squdisautotest.pageObject.squdisPageObject.SquidsPage;
import com.duoyun.suqids.autotest.ui.squdisautotest.service.LoginService;
import org.apache.log4j.PropertyConfigurator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;


@SpringBootTest
public class SqudisAutoTestApplicationTests extends AbstractTestNGSpringContextTests {

    static {
        PropertyConfigurator.configure("src/main/resources/log4j.properties");
    }

    @Autowired
    private SquidsPage squidsPage;

    @Autowired
    private LoginService loginService;

    @Autowired
    private CreateDataBasePage dataBasePage;

    @Autowired
    Actions actions;
    @Autowired
    SeleActions seleActions;

    @AfterMethod
    public void tearDown() {
        catchScreenshot();
        actions.closeBrowser();
    }

    /**
     * 失败用例重试3次依旧失败则截图保存
     */
    private void catchScreenshot(){
        CaseListener caseListener = new CaseListener();
        String failCaseName = caseListener.failCaseName;
        boolean caseResult = caseListener.failResult;
        if(caseResult) {
            try {
                if (LoginFactory.loginModel.getDriverType() == 0) {
                    actions.catchScreenshot(failCaseName);
                } else if (LoginFactory.loginModel.getDriverType() == 1) {
                    seleActions.catchScreenshot(failCaseName);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            caseListener.failCaseName = null;
            caseListener.failResult = false;
        }
    }

    /**
     * 登录
     */
    private void loginSquids(){
        loginService.loginSquids();
    }
    /**
     * squids登录
     */
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

}
