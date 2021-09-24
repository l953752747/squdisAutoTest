package com.duoyun.suqids.autotest.ui.squdisautotest.dataprovider.config;

import com.duoyun.suqids.autotest.ui.squdisautotest.dataprovider.DataMocker;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataConfig {

    @Value("${browser}")
    public String browser;


    @Bean
    public DataMocker dataMocker(){
        DataMocker mocker = new DataMocker();
        mocker.browser=browser;
        return mocker;
    }
}
