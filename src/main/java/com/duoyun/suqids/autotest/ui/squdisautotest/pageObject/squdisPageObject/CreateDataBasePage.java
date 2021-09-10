package com.duoyun.suqids.autotest.ui.squdisautotest.pageObject.squdisPageObject;

public interface CreateDataBasePage {
    /**
     * 点击create database
     */

    void OpenCreateDatabase();

    /**
     * 选择数据库
     */
    void clickDataBase();

    /**
     * 选择云提供商
     */
    void cliclProvider();

    /**
     * 选择地区
     */
    void clickArea();

    /**
     * 选择城市
     */
    void clickCity();

    /**
     * 选择云提供商的凭证
     */
    void clickCredentials();

    /**
     * 选择主机level
     */
    void clickServiceLevel();

    /**
     * 选择主机配置
     */

    void clickServicePackage();

    /**
     * 输入集群别名
     */
    void inputDataBaseAlias();

    /**
     * 选择数据库版本
     */

    void clickDatabaseVersion();

    /**
     * 输入数据库权限用户名
     */
    void inputDataBaseAdminAccount();

    /**
     * 输入数据库用户密码
     */
    void inputAdminAccountPassword();

    /**
     * 输入备份天数
     */
    void inputRetentionDays();

    /**
     * 选择备份开始具体小时
     */
    void clickBeginHour();

    /**
     * 选择备份开始的具体分钟
     */
    void clickBeginMinute();

    /**
     * 选择公网勾选
     */
    void clickPublicNetWork();

    /**
     * 点击创建
     */

    void clickCreateDataBase();
}
