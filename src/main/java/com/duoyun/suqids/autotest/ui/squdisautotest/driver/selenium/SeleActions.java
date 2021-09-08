package com.duoyun.suqids.autotest.ui.squdisautotest.driver.selenium;

public interface SeleActions {


    /**
     * 登入H5页面
     */
    void openH5Url(String url);

    /**
     * 登入失败重试
     * 有10次重试机会，每次间隔10s
     *
     * @param url
     */
    void reLoadPage(String url);

    /**
     * 点击
     */
    void click(String element);

    /**
     * 输入
     *
     * @param element
     */
    void input(String element, String content);

    /**
     * 校验
     *
     * @param element
     * @param expect
     */
    void assertShouldContain(String element, String expect);

    /**
     * 获取字符串
     *
     * @param element
     * @return
     */
    String getText(String element);

    /**
     * 关闭浏览器
     */
    void closeBrowser();

    /**
     * 元素可点击, 适应于button, input and text等元素
     *
     * @param element
     * @param timeout
     */
    void waitingForElementClickable(final String element, long timeout);

    /**
     * 通过字符串选择控件
     *
     * @param element
     * @param value
     */
    void selectByValue(String element, String value);

    /**
     * 获取url
     *
     * @return
     */
    String getUrl();

    /**
     * 刷新
     */
    void refresh();

    /**
     * 获取截屏并命名
     */
    void catchScreenshot(String filename);

    /**
     * 点击
     * 当组件描述是相同字符串不唯一时，可通过index进行定位
     *
     * @param element
     * @param index
     */
    void clickByIndex(String element, int index);
}
