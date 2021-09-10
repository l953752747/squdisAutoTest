package com.duoyun.suqids.autotest.ui.squdisautotest.driver.common;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;

import java.awt.*;
import java.awt.event.KeyEvent;


@Slf4j
public class Common {
    /**
     * 解析元素
     * @param element
     * @param elementType: xpath,css,name
     * @return
     */
    public By parseElement(String element, String ... elementType){
        By anaElement;
        String curElementType="tmp";

        if(elementType.length>0) {
            curElementType = elementType[0].toString().toLowerCase();
        }

        try {
            if (element.contains("//") || curElementType.equals("xpath")) { //element is xpath
                anaElement = By.xpath(element);
            } else if (element.contains(".") || element.contains("#")||curElementType.equals("css")) { // element is css selector
                anaElement = By.cssSelector(element);
            } else if(curElementType.equals("name")){ // element is name
                anaElement = By.name(element);
            } else{ //element is id
                anaElement = By.id(element);
            }
            return anaElement;
        }catch (Error e){
            log.error(e.getMessage());
            throw new RuntimeException(e);
        }
    }

    /**
     * drag web via down key
     * @param times
     */
    public void robotKey_Tab(int times){
        try {
            Robot robot = new Robot();
            for(int i=0;i<times; i++) {
                robot.keyPress(KeyEvent.VK_TAB);
                robot.keyRelease(KeyEvent.VK_TAB);
            }
        }catch (AWTException awt){
            throw new RuntimeException(awt);
        }
    }
}
