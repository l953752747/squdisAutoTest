package com.duoyun.suqids.autotest.ui.squdisautotest.driver.selenide;

import com.codeborne.selenide.ElementsCollection;
import org.openqa.selenium.By;

import java.util.Set;

public interface Actions {

    /**
     * 启动浏览器，访问url
     * @param url
     */
    void openUrl(String url);

    /**
     * 清除cookies
     */
    void clearCookies();

    /**
     * 输入： 支持 id, xpath ,name or css selector
     * @param element
     * @param content
     */
    void input(String element, String content,String ...elementType);

    /**
     * 输入： 支持 id, xpath ,name or css selector
     * 当组件描述是相同字符串不唯一时，可通过index进行定位
     * @param element
     * @param content
     */
    void input(String element, String content,int index,String ...elementType);

    /**
     * 触发输入： 支持 id, xpath ,name or css selector
     * 有些组件需要先触发一下才能正常输入
     * @param element
     */
    void triggerInput(String element,String ...elementType);

    /**
     * 点击： 支持 id, xpath,css selector, name
     * @param element
     */
    void click(String element,String ...elementType);

    /**
     * 点击： 支持 id, xpath,css selector, name
     * 当组件描述是相同字符串不唯一时，可通过index进行定位
     * */
    void click(String element, int index, String ...elementType);


    /**
     *  点击文本
     * */
    void clickByText(String text);

    /**
     * 鼠标移动至： 支持 id, xpath,css selector, name
     * @param element
     */
    void hover(String element,String ...elementType);

    /**
     *  利用js模拟点击
     * */
    void clickByJs(String selector);

    /**
     * 切换 frame
     * @param element
     */
    void switchToFrame(String element);

    /**
     * 切换窗口, 通过index定位窗口
     * @param index
     */
    void swtichToWindow(int index);

    /**
     * 等待元素加载
     * timeout xxx mils
     * @param element
     * @param timeout
     */
    By waitingForElementLoad(String element, long timeout, String ...elementType);

    /**
     * 等待元素消失
     * */
    boolean waitWhileElementGone(String element);

    /**
     * select the target string in comboBox, by id, xpath,css selector, name
     * via click to control combo box by now. The interface need improve
     * @param element
     * @param target
     */
    void comboBoxAction(String element,String target,String ...elementType);

    /**
     * 校验：元素包含预期字符串
     */
    void assertShouldContain(String element, String expect,String ...elementType);
    /**
     * 校验：元素包含预期字符串,被测元素如果有多个,可通过index定位
     */
    void assertShouldContain(String element, String expect,int index, String ...elementType);

    /**
     * 获取元素属性值
     */
    String getValueByAttribute(String element,String attribute,String ...elementType);

    /**
     * 键盘回车键：支持 id, xpath,css selector, name
     * @param element
     */
    void pressEnter(String element,String ...elementType);

    /**
     * 键盘TAB键：支持 id, xpath,css selector, name
     * @param element
     */
    void pressTab(String element,String ...elementType);

    /**
     * 等待页面元素加载完成，并获取url
     * @param element
     * @param elementType
     * @return
     */
    String getUrl(String element,String ...elementType);

    /**
     * 关闭浏览器
     */
    void closeBrowser();

    /**
     * 退出当前页
     * */
    void quit(int index);

    /**
     * 上传文件：支持 id, xpath,css selector, name
     * @param element
     * @param filePath
     */
    void uploadFile(String element,String filePath,String ...elementType);

    /**
     * 刷新当前页
     */
    void refresh();

    /**
     *  查找元素集合
     * */
    ElementsCollection findForElements(String element, String ...elementType);

    /**
     * 滚动页面到元素位置
     * */
    void  scrollToElement(String element,String ...elementType);

    /**
     * 获取所有已打开标签页面hanlde
     * */
    Set<String> getAllWindowHandles();

    /**
     *  获取页面title
     * */
    String getTitle();

    /**
     * usage: please call the api before load a new url
     *  - `normal`: return after the load event fires on the new page (it's default in Selenium webdriver);
     *  - `eager`: return after DOMContentLoaded fires;
     *  - `none`: return immediately
     * @param level
     */
    void waitingForPageLoad(String level);

    String getPageSource();

    void selectByValue(String element,String value,String ... elementType);

    /**
     * 暂停毫秒数
     * @param milSec
     */
    void pause(int milSec);

    /**
     * 获取元素中的值
     * @param element
     * @return
     */
    String getValue(String element,String ... elementType);

    /**
     * 获取截屏并命名
     */
    void catchScreenshot(String fileName);
}
