package com.duoyun.suqids.autotest.ui.squdisautotest.driver.selenide.impl;

import com.codeborne.selenide.*;
import com.duoyun.suqids.autotest.ui.squdisautotest.dataprovider.login.LoginFactory;
import com.duoyun.suqids.autotest.ui.squdisautotest.driver.common.Common;
import com.duoyun.suqids.autotest.ui.squdisautotest.driver.selenide.Actions;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.Set;

import static com.codeborne.selenide.Selectors.byText;

@Service
@Slf4j
public class ActionsImpl implements Actions {
    private long elementTimeout = 20000;
    private Common commonDriver = new Common();

    public void openUrl(String url){
        LoginFactory.loginModel.setDriverType(0);
        Selenide.open(url);
    }


    public void clearCookies(){
        Selenide.clearBrowserCookies();
    }

    public void switchToFrame(String element){
        Selenide.switchTo().frame(element);
    }

    public void swtichToWindow(int index){
        Selenide.switchTo().window(index);
    }

    public void input(String element, String content,String ...elementType){
        if(null == content){
            log.error("input content error -> " + content);
            throw new NullPointerException();
        }
        By elementLocator = isElementLoaded(element,elementTimeout,elementType);
        //clear first then input content
        Selenide.$(elementLocator).sendKeys(Keys.HOME, Keys.chord(Keys.SHIFT, Keys.END), content);
    }

    public void input(String element, String content,int index, String ...elementType){
        if(null == content){
            log.error("input content error -> " + content);
            throw new NullPointerException();
        }
        By elementLocator = isElementLoaded(element,elementTimeout,elementType);
        //clear first then input content
        Selenide.$(elementLocator,index).sendKeys(Keys.HOME, Keys.chord(Keys.SHIFT, Keys.END), content);
    }

    public void triggerInput(String element,String ...elementType){
        By elementLocator = isElementLoaded(element,elementTimeout,elementType);
        Selenide.$(elementLocator).sendKeys();
    }

    public void click(String element,String ...elementType){
        By elementLocator = isElementLoaded(element,elementTimeout,elementType);
        scrollToElement(element,elementType);
        Selenide.$(elementLocator).click();
    }

    @Override
    public void click(String element, int index, String ...elementType) {
        By elementLocator = isElementLoaded(element,elementTimeout,elementType);
        scrollToElementOnWindow(elementLocator);
        Selenide.$(elementLocator, index).click();
    }

    @Override
    public void clickByText(String text) {
        Selenide.$(byText(text)).click();
    }

    @Override
    public void clickByJs(String selector) {
        WebElement element = WebDriverRunner.getWebDriver().findElement(By.cssSelector(selector));
        String jscode = "arguments[0].click();";
        Selenide.executeJavaScript(jscode, element);
        Selenide.sleep(1000);
    }

    /**
     * 两次timeout机会，如果没有找到元素抛null异常
     * @param element
     * @param timeout
     * @param elementType
     * @return
     */
    private By isElementLoaded(String element, long timeout,String ...elementType){
        By elementLocator = null;
        int count = 4;
        long partTimeout = timeout/count;
        for(int i=0; i<count; i++) {
            elementLocator = waitingForElementLoad(element, partTimeout, elementType);
            if(null != elementLocator){
                break;
            }else if (null == elementLocator && (count-1) == i) {//元素为null抛出异常
                log.error("Web页面元素：{} 无法定位",element);
            }
        }
        return elementLocator;
    }

    public By waitingForElementLoad(String element, long timeout,String ...elementType){
        By elementLocator = getElementLocator(commonDriver.parseElement(element,elementType),timeout);
        return elementLocator;
    }

    private By getElementLocator(By elementLocator, long timeout){
        boolean loadResult = checkElementLoad(elementLocator, timeout);
        if(loadResult){
            return elementLocator;
        }
        return null;
    }

    @Override
    public boolean waitWhileElementGone(String element) {
        By elementLocator = commonDriver.parseElement(element);
        try {
            Selenide.$(elementLocator).waitUntil(Condition.disappears, 10000);
            return true;
        }catch (Error er) {
            throw new RuntimeException(er);
        }catch (Exception ex){
            throw new RuntimeException(ex);
        }
    }

    private boolean checkElementLoad(By elementLocator, long timeout){
        try {
            Selenide.$(elementLocator).waitUntil(Condition.appears, timeout);
            return true;
        }catch (Error er) {
            throw new RuntimeException(er);
        }catch (Exception ex){
            throw new RuntimeException(ex);
        }
    }

    public void comboBoxAction(String element,String target,String ...elementType){
        By elementLocator = isElementLoaded(element,elementTimeout,elementType);
        Selenide.$(elementLocator).selectOptionByValue(target);
    }

    public void assertShouldContain(String element,String expect,String ...elementType){
        By elementLocator = isElementLoaded(element,elementTimeout,elementType);
        Selenide.$(elementLocator).shouldHave(Condition.matchesText(expect));
    }

    public void assertShouldContain(String element,String expect,int index, String ...elementType){
        By elementLocator = isElementLoaded(element,elementTimeout,elementType);
        Selenide.$(elementLocator,index).shouldHave(Condition.matchesText(expect));
    }

    public String getValueByAttribute(String element,String attribute,String ...elementType){
        By elementLocator = isElementLoaded(element,elementTimeout,elementType);
        try {
            String value = Selenide.$(elementLocator).getAttribute(attribute);
            return value;
        }catch (Error er) {
            throw new RuntimeException(er);
        }catch (Exception ex){
            throw new RuntimeException(ex);
        }
    }

    public void pressEnter(String element,String ...elementType){
        By elementLocator = isElementLoaded(element,elementTimeout,elementType);
        Selenide.$(elementLocator).pressEnter();
    }

    public void pressTab(String element,String ...elementType){
        By elementLocator = isElementLoaded(element,elementTimeout,elementType);
        Selenide.$(elementLocator).pressTab();
    }

    public String getUrl(){
        pause(2000);
        return WebDriverRunner.url();
    }

    public String getUrl(String element,String ...elementType){
        String getUrl = WebDriverRunner.url();
        if(getUrl.equals("data:,") || getUrl.equals("about:blank")){
            for(int i=0; i<5; i++){
                try {
                    isElementLoaded(element, elementTimeout, elementType);
                }catch (Exception ex){
                    log.warn(ex.getMessage());
                }
                getUrl = WebDriverRunner.url();
                if(!getUrl.equals("data:,") && !getUrl.equals("about:blank")){
                    break;
                }else if(i == 5){
                    throw new Error();
                }else{
                    refresh();
                }
            }
        }
        return getUrl;
    }

    public void refresh(){
        Selenide.refresh();
    }

    public void uploadFile(String element,String filePath,String ...elementType){
        File file = new File(filePath);
        Selenide.$(commonDriver.parseElement(element,elementType)).uploadFile(file);
    }

    /**
     * close browser
     */
    public void closeBrowser(){
        try {
            Selenide.close();
        }catch (Error er) {
            log.error("Error " + er.getMessage());
        }catch (Exception ex){
            log.error("Exception Message: "+ex.getMessage());
        }
    }

    @Override
    public void quit(int index) {
        Selenide.switchTo().window(index).close();
        if ( (index-1) > 0){
            Selenide.switchTo().window(index - 1);
        }
    }

    public void hover(String element,String ...elementType){
        By elementLocator = isElementLoaded(element,elementTimeout,elementType);
        Selenide.$(elementLocator).hover();
    }


    public ElementsCollection findForElements(String element, String ...elementType){
        By elementLocator = isElementLoaded(element,elementTimeout,elementType);
        try {
            return Selenide.$$(elementLocator);
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public void scrollToElement(String element,String ...elementType) {
        By elementLocator = isElementLoaded(element,elementTimeout,elementType);
        scrollToElementOnWindow(elementLocator);
    }

    private void scrollToElementOnWindow(By elementLocator) {
        Selenide.$(elementLocator).scrollTo();
    }

    @Override
    public Set<String> getAllWindowHandles() {
        return WebDriverRunner.getWebDriver().getWindowHandles();
    }

    @Override
    public String getTitle() {
        return Selenide.title();
    }

    public  void waitingForPageLoad(String level){
        Configuration.pageLoadStrategy = level;
    }

    @Override
    public String getPageSource() {
        return WebDriverRunner.getWebDriver().getPageSource();
    }

    public void selectByValue(String element,String value,String ... elementType){
        By elementLocator = isElementLoaded(element,elementTimeout,elementType);
        Select sel = new Select(Selenide.$(elementLocator).findElement(elementLocator));
        sel.selectByValue(value);
    }

    public void pause(int milSec){
        Selenide.sleep(milSec);
    }

    public String getValue(String element,String ... elementType){
        By elementLocator = isElementLoaded(element,elementTimeout,elementType);
        return Selenide.$(elementLocator).getValue();

    }

    public void catchScreenshot(String fileName){
        Selenide.screenshot(fileName);
    }
}
