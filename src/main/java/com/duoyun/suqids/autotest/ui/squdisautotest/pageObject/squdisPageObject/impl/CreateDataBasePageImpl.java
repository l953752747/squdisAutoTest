package com.duoyun.suqids.autotest.ui.squdisautotest.pageObject.squdisPageObject.impl;

import com.duoyun.suqids.autotest.ui.squdisautotest.driver.selenide.Actions;
import com.duoyun.suqids.autotest.ui.squdisautotest.pageObject.squdisPageObject.CreateDataBasePage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
@Slf4j
public class CreateDataBasePageImpl implements CreateDataBasePage {
    private final static String oepnCreateElement = "button.ant-btn.createBtn";
    private final static String mysqlElement = "//*[@class='service']/div[1]";
    private final static String reidsElement = "//*[@class='service']/div[2]";
    private final static String mssqlElement = "//*[@class='service']/div[3]";
    private final static String awsProviderElement = "//*[@class='provider']/button[1]";
    private final static String aliyunProviderElement = "//*[@class='provider']/button[2]";
    private final static String AsiaPacificElement = "//*[@class='provider__region']/div/div[1]/div/div/div[1]";
    private final static String NorthAmericaElement = "//*[@class='provider__region']/div/div[1]/div/div/div[2]";
    private final static String SouthAmericaElement = "//*[@class='provider__region']/div/div[1]/div/div/div[3]";
    private final static String EuropeElement = "//*[@class='provider__region']/div/div[1]/div/div/div[4]";
    private final static String MiddleEastElement = "//*[@class='provider__region']/div/div[1]/div/div/div[5]";
    private final static String AfricaElement = "//*[@class='provider__region']/div/div[1]/div/div/div[6]";
    private final static String OsakaElement = "//*[@class='provider__region']/div/div[2]/div/div[1]/div/div/label[1]";
    private final static String SingaporeElement = "//*[@class='provider__region']/div/div[2]/div/div[1]/div/div/label[2]";
    private final static String SydneyElement = "//*[@class='provider__region']/div/div[2]/div/div[1]/div/div/label[3]";
    private final static String MumbaiElement = "//*[@class='provider__region']/div/div[2]/div/div[1]/div/div/label[4]";
    private final static String SeoulElement = "//*[@class='provider__region']/div/div[2]/div/div[1]/div/div/label[5]";
    private final static String TokyoElement = "//*[@class='provider__region']/div/div[2]/div/div[1]/div/div/label[6]";
    private final static String HongKongElement = "//*[@class='provider__region']/div/div[2]/div/div[1]/div/div/label[7]";
    private final static String CanadaElement = "//*[@class='provider__region']/div/div[2]/div/div[2]/div/div/label[1]";
    private final static String OhioElement = "//*[@class='provider__region']/div/div[2]/div/div[2]/div/div/label[2]";
    private final static String NorthernVirginiaElement = "//*[@class='provider__region']/div/div[2]/div/div[2]/div/div/label[3]";
    private final static String NorthernCaliforniaElement = "//*[@class='provider__region']/div/div[2]/div/div[2]/div/div/label[4]";
    private final static String OregonElement = "//*[@class='provider__region']/div/div[2]/div/div[2]/div/div/label[5]";
    private final static String SaoPauloElement = "//*[@class='provider__region']/div/div[2]/div/div[3]/div/div/label[1]";
    private final static String StockholmElement = "//*[@class='provider__region']/div/div[2]/div/div[4]/div/div/label[1]";
    private final static String ParisElement = "//*[@class='provider__region']/div/div[2]/div/div[4]/div/div/label[2]";
    private final static String MilanElement = "//*[@class='provider__region']/div/div[2]/div/div[4]/div/div/label[3]";
    private final static String LondonElement = "//*[@class='provider__region']/div/div[2]/div/div[4]/div/div/label[4]";
    private final static String IrelandElement = "//*[@class='provider__region']/div/div[2]/div/div[4]/div/div/label[5]";
    private final static String FrankfurtElement = "//*[@class='provider__region']/div/div[2]/div/div[4]/div/div/label[6]";
    private final static String BahrainElement = "//*[@class='provider__region']/div/div[2]/div/div[5]/div/div/label[1]";
    private final static String CapeTownElement = "//*[@class='provider__region']/div/div[2]/div/div[6]/div/div/label[1]";
    private final static String credentialsElement = "//*[@class='rc-virtual-list-holder-inner']/div";
    private final static String businessLevelEelement = "//*[@class=\"package\"]/div/div/div[1]/div/div[1]";
    private final static String consumerLevelElement = "//*[@class=\"package\"]/div/div/div[1]/div/div[2]";
    private final static String Bc2m4cxElement = "//*[@class='ant-tabs-content ant-tabs-content-top']/div[1]/div/div[3]/label[2]";
    private final static String Bc2m8cxElement = "//*[@class='ant-tabs-content ant-tabs-content-top']/div[1]/div/div[3]/label[3]";
    private final static String Bc4m16cxElement = "//*[@class='ant-tabs-content ant-tabs-content-top']/div[1]/div/div[3]/label[4]";
    private final static String Bc8m32cxElement = "//*[@class='ant-tabs-content ant-tabs-content-top']/div[1]/div/div[3]/label[5]";
    private final static String Bc16m64cxElement = "//*[@class='ant-tabs-content ant-tabs-content-top']/div[1]/div/div[3]/label[6]";
    private final static String Bc32m128cxElement = "//*[@class='ant-tabs-content ant-tabs-content-top']/div[1]/div/div[3]/label[7]";
    private final static String Bc48m192cxElement = "//*[@class='ant-tabs-content ant-tabs-content-top']/div[1]/div/div[3]/label[8]";
    private final static String Bc2m8lxElement = "//*[@class='ant-tabs-content ant-tabs-content-top']/div[1]/div/div[3]/label[9]";
    private final static String Bc4m16lxElement = "//*[@class='ant-tabs-content ant-tabs-content-top']/div[1]/div/div[3]/label[10]";
    private final static String Bc8m32lxElement = "//*[@class='ant-tabs-content ant-tabs-content-top']/div[1]/div/div[3]/label[11]";
    private final static String Bc16m64lxElement = "//*[@class='ant-tabs-content ant-tabs-content-top']/div[1]/div/div[3]/label[12]";
    private final static String Bc32m128lxElement = "//*[@class='ant-tabs-content ant-tabs-content-top']/div[1]/div/div[3]/label[13]";
    private final static String Bc48m192lxElement = "//*[@class='ant-tabs-content ant-tabs-content-top']/div[1]/div/div[3]/label[14]";
    private final static String DatabaseAliasElement = "//*[@class='alias_box']/div/div[2]/div/div/input";
    private final static String AdminAccountElement = "//*[@class='account_box']/div/div[2]/div/div/input";
    private final static String PasswordElement = "//*[@class='account_box']/div[2]/div[2]/div/div/span/input";


    @Autowired
    Actions actions;

    /**
     * ????????????????????????
     */
    public void OpenCreateDatabase() {
        actions.click(oepnCreateElement, "css");
    }

    /**
     * ????????????????????????MySQL
     */
    public void clickDataBase() {
        actions.click(mysqlElement, "xpath");
    }

    /**
     * ???????????????????????????????????????
     *
     * @param database
     */
    public void clickDataBase(String database) {
        if (database.equals("MySQL")) {
            actions.click(mysqlElement, "xpath");
        } else if (database.equals("Redis")) {
            actions.click(reidsElement, "xpath");
        } else if (database.equals("mssql")) {
            actions.click(mssqlElement, "xpath");
        }
    }

    /**
     * ???????????????????????????aws
     */
    public void cliclProvider() {
        actions.click(awsProviderElement, "xpath");
    }

    /**
     * ??????????????????????????????????????????
     *
     * @param providerName
     */
    public void cliclProvider(String providerName) {
        if (providerName.equals("aws")) {
            actions.click(awsProviderElement, "xpath");
        } else if (providerName.equals("aliyun")) {
            actions.click(aliyunProviderElement, "xpath");
        }
    }

    /**
     * ?????????????????????Asia Pacific
     */
    public void clickArea() {
        actions.click(AsiaPacificElement, "xpath");
    }


    /**
     * ????????????????????????????????????
     *
     * @param Area
     */
    public void clickArea(String Area, String city) {
        if (Area.equals("Asia Pacific")) {
            actions.click(AsiaPacificElement, "xpath");
        } else if (Area.equals("North America")) {
            actions.click(NorthAmericaElement, "xpath");
        } else if (Area.equals("South America")) {
            actions.click(SouthAmericaElement, "xpath");
        } else if (Area.equals("Europe")) {
            actions.click(EuropeElement, "xpath");
        } else if (Area.equals("Middle East")) {
            actions.click(MiddleEastElement, "xpath");
        } else if (Area.equals("Africa")) {
            actions.click(AfricaElement, "xpath");
        }
    }

    /**
     * ???????????????????????????osaka
     */
    public void clickCity() {
        actions.click(OsakaElement, "xpath");
    }

    private void clickCity(String City) {
        if (City.equals("Osaka")) {
            actions.click(OsakaElement, "xpath");
        } else if (City.equals("Singapore")) {
            actions.click(SingaporeElement, "xpath");
        } else if (City.equals("Sydney")) {
            actions.click(SydneyElement, "xpath");
        } else if (City.equals("Seoul")) {
            actions.click(SeoulElement, "xpath");
        } else if (City.equals("Tokyo")) {
            actions.click(TokyoElement, "xpath");
        } else if (City.equals("HongKong")) {
            actions.click(HongKongElement, "xpath");
        } else if (City.equals("Canada")) {
            actions.click(CanadaElement, "xpath");
        } else if (City.equals("Ohio")) {
            actions.click(OhioElement, "xpath");
        } else if (City.equals("NorthernVirginia")) {
            actions.click(NorthernVirginiaElement, "xpath");
        } else if (City.equals("NorthernCalifornia")) {
            actions.click(NorthernCaliforniaElement, "xpath");
        } else if (City.equals("Oregon")) {
            actions.click(OregonElement, "xpath");
        } else if (City.equals("SaoPaulo")) {
            actions.click(SaoPauloElement, "xpath");
        } else if (City.equals("Stockholm")) {
            actions.click(StockholmElement, "xpath");
        } else if (City.equals("Paris")) {
            actions.click(ParisElement, "xpath");
        } else if (City.equals("Milan")) {
            actions.click(MilanElement, "xpath");
        } else if (City.equals("London")) {
            actions.click(LondonElement, "xpath");
        } else if (City.equals("Ireland")) {
            actions.click(IrelandElement, "xpath");
        } else if (City.equals("Frankfurt")) {
            actions.click(FrankfurtElement, "xpath");
        }else if (City.equals("Bahrain")) {
            actions.click(BahrainElement, "xpath");
        }else if (City.equals("CapeTown")) {
            actions.click(CapeTownElement, "xpath");
        }

    }


    /**
     * ???????????????????????????????????????
     *
     * @param Area
     * @param City
     */
    public void clickCity(String Area, String City) {
        if (Area.equals("Asia Pacific")) {
            if (City.equals("Osaka")) {
                actions.click(OsakaElement, "xpath");
            } else if (City.equals("Singapore")) {
                actions.click(SingaporeElement, "xpath");
            } else if (City.equals("Sydney")) {
                actions.click(SydneyElement, "xpath");
            } else if (City.equals("Seoul")) {
                actions.click(SeoulElement, "xpath");
            } else if (City.equals("Tokyo")) {
                actions.click(TokyoElement, "xpath");
            } else if (City.equals("HongKong")) {
                actions.click(HongKongElement, "xpath");
            }
        } else if (Area.equals("North America")) {
            if (City.equals("Canada")) {
                actions.click(CanadaElement, "xpath");
            } else if (City.equals("Ohio")) {
                actions.click(OhioElement, "xpath");
            } else if (City.equals("NorthernVirginia")) {
                actions.click(NorthernVirginiaElement, "xpath");
            } else if (City.equals("NorthernCalifornia")) {
                actions.click(NorthernCaliforniaElement, "xpath");
            } else if (City.equals("Oregon")) {
                actions.click(OregonElement, "xpath");
            }
        } else if (Area.equals("South America")) {
            actions.click(SaoPauloElement, "xpath");
        } else if (Area.equals("Europe")) {
            if (City.equals("Stockholm")) {
                actions.click(StockholmElement, "xpath");
            } else if (City.equals("Paris")) {
                actions.click(ParisElement, "xpath");
            } else if (City.equals("Milan")) {
                actions.click(MilanElement, "xpath");
            } else if (City.equals("London")) {
                actions.click(LondonElement, "xpath");
            } else if (City.equals("Ireland")) {
                actions.click(IrelandElement, "xpath");
            } else if (City.equals("Frankfurt")) {
                actions.click(FrankfurtElement, "xpath");
            }
        } else if (Area.equals("Middle East")) {
            actions.click(BahrainElement, "xpath");
        } else if (Area.equals("Africa")) {
            actions.click(CapeTownElement, "xpath");
        }
    }

    /**
     * ???????????????????????????
     */
    public void clickCredentials() {
        actions.click(credentialsElement,"xpath");
    }

    /**
     * ????????????bussiness-level
     */
    public void clickServiceLevel() {
        actions.click(businessLevelEelement,"xpath");
    }

    /**
     * ??????????????????????????????
     */
    public void clickServiceLevel(String level){
        if (level.equals("Business-level")){
            actions.click(businessLevelEelement,"xpath");
        }else if (level.equals("Consumer-level")){
            actions.click(consumerLevelElement,"xpath");
        }
    }

    /**
     * ?????????????????????
     */
    public void clickServicePackage() {
        actions.click(Bc2m4cxElement,"xpath");
    }

    /**
     * ??????????????????????????????
     * @param servicePackage
     */
    public void clickServicePackage(String servicePackage) {
        if (servicePackage.equals("B-c2m4cx")){
            actions.click(Bc2m4cxElement,"xpath");
        }else if (servicePackage.equals("B-c2m8cx")){
            actions.click(Bc2m8cxElement,"xpath");
        }else if (servicePackage.equals("B-c4m16cx")){
            actions.click(Bc4m16cxElement,"xpath");
        }else if (servicePackage.equals("B-c16m64cx")){
            actions.click(Bc16m64cxElement,"xpath");
        }else if (servicePackage.equals("B-c32m128cx")){
            actions.click(Bc32m128cxElement,"xpath");
        }else if (servicePackage.equals("Bc48cx192cx")){
            actions.click(Bc48m192cxElement,"xpath");
        }else if (servicePackage.equals("B-c2m8lx")){
            actions.click(Bc2m8lxElement,"xpath");
        }else if (servicePackage.equals("B-c4m16lx")){
            actions.click(Bc4m16lxElement,"xpath");
        }else if (servicePackage.equals("B-c16m64lx")){
            actions.click(Bc16m64lxElement,"xpath");
        }else if (servicePackage.equals("B-c32m128lx")){
            actions.click(Bc32m128lxElement,"xpath");
        }else if (servicePackage.equals("B-c48m192lx")){
            actions.click(Bc48m192lxElement,"xpath");
        }
    }

    /**
     * ??????????????????????????????
     */
    public void inputDataBaseAlias() {
        actions.click(DatabaseAliasElement,"xpath");
    }

    /**
     * ????????????????????????
     */
    public void inputDataBaseAlias(String dataBaseAlias){
        actions.input(DatabaseAliasElement,dataBaseAlias,"xpath");
    }

    /**
     * ??????????????????
     */
    public void clickDatabaseVersion() {

    }

    @Override
    public void inputDataBaseAdminAccount() {

    }

    @Override
    public void inputAdminAccountPassword() {

    }

    @Override
    public void inputRetentionDays() {

    }

    @Override
    public void clickBeginHour() {

    }

    @Override
    public void clickBeginMinute() {

    }


    /**
     * ????????????
     */
    @Override
    public void clickPublicNetWork() {
        actions.click("span.ant-checkbox","css");
    }

    @Override
    public void clickCreateDataBase() {

    }
}
