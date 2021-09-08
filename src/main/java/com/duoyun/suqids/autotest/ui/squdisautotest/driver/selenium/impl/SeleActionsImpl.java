package com.duoyun.suqids.autotest.ui.squdisautotest.driver.selenium.impl;


import com.duoyun.suqids.autotest.ui.squdisautotest.dataprovider.login.LoginFactory;
import com.duoyun.suqids.autotest.ui.squdisautotest.driver.common.Common;
import com.duoyun.suqids.autotest.ui.squdisautotest.driver.selenium.SeleActions;
import com.duoyun.suqids.autotest.ui.squdisautotest.utils.PauseUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
@Service
public class SeleActionsImpl implements SeleActions {
    private Common commonDriver = new Common();
    private WebDriver driver;
    private long elementTimeout = 20000;

    public void openH5Url(String url){
        LoginFactory.loginModel.setDriverType(1);
        try {
            Map<String, String> mobileEmulation = new HashMap<String, String>();
            mobileEmulation.put("deviceName", "iPhone 6 Plus");
            Map<String, Object> chromeOptions = new HashMap<String, Object>();
            chromeOptions.put("mobileEmulation", mobileEmulation);
            DesiredCapabilities capabilities = DesiredCapabilities.chrome();
            capabilities.setCapability(ChromeOptions.CAPABILITY, chromeOptions);
            driver = new ChromeDriver(capabilities);
            WebDriver.Navigation navigation = driver.navigate();
            if(url.equals("about:blank") || url.equals("data:,")){
                throw new Error();
            }else {
                navigation.to(url);
            }
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    /**
     * 判断当前页面是否正常
     * @return
     */
    private boolean checkUrl(){
        String curUrl = getUrl();
        if(curUrl.contains("new_404")){
            return false;
        }
        return true;
    }

    public void reLoadPage(String url){
        for(int i=0; i<10; i++) {
            if (checkUrl()) {
                break;
            } else {
                closeBrowser();
                openH5Url(url);
            }
        }
    }

    public void click(String element){
        By elementLocator = isElementLoaded(element,elementTimeout);
        PauseUtils.pause(2000);
        driver.findElement(elementLocator).click();
    }

    public void clickByIndex(String element,int index){
        By elementLocator = isElementLoaded(element,elementTimeout);
        PauseUtils.pause(2000);
        driver.findElements(elementLocator).get(index).click();
    }

    public void input(String element,String content){
        By elementLocator = isElementLoaded(element,elementTimeout);
        driver.findElement(elementLocator).sendKeys(content);
    }

    public void waitingForElementClickable(String element, long timeout){
        By elementLocator = isElementLoaded(element,timeout);
        long seconds = timeout/1000;
        new WebDriverWait(driver, seconds).until(ExpectedConditions.elementToBeClickable(elementLocator));
    }

    public void assertShouldContain(String element,String expect){
        String targetValue = getText(element);
        assertThat(targetValue).contains(expect);
    }

    public String getText(String element){
        By elementLocator = isElementLoaded(element,elementTimeout);
        try {
            String targetValue = driver.findElement(elementLocator).getText();
            return targetValue;
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    public void closeBrowser(){
        if (driver != null) {
            try {
                driver.close();
            }catch (Error e){
                log.error("Error message: "+e.getMessage());
            }
        }
    }

    public void selectByValue(String element,String value){
        By elementLocator = isElementLoaded(element,elementTimeout);
        Select sel = new Select(driver.findElement(elementLocator));
        sel.selectByValue(value);
    }

    public String getUrl(){
        String url = driver.getCurrentUrl();
        return url;
    }

    public void refresh(){
        driver.navigate().refresh();
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
            elementLocator = waitingForElementLoad(element,partTimeout,elementType);
            if(null != elementLocator){
                break;
            }else if (null == elementLocator && (count-1) == i) {//元素为null抛出异常
                log.error("H5页面元素：{} 无法定位", element);
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

    private boolean checkElementLoad(By elementLocator, long timeout){
        try {
            long seconds = timeout/1000;
            new WebDriverWait(driver, seconds).until(ExpectedConditions.visibilityOfAllElementsLocatedBy(elementLocator));
            return true;
        }catch (Error er) {
            throw new RuntimeException(er);
        }catch (Exception ex){
            throw new RuntimeException(ex);
        }
    }

    // this method will take screen shot ,require two parameters ,one is driver name, another is file name
    public void catchScreenshot(String filename) {
        File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        // Now you can do whatever you need to do with it, for example copy somewhere
        try {
            String rootPath = System.getProperty("user.dir");
            String filePath = rootPath+"/build/reports/tests/"+filename;
            FileUtils.copyFile(scrFile, new File(filePath+"_selenium.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
