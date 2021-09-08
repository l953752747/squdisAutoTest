package com.duoyun.suqids.autotest.ui.squdisautotest.utils;

import lombok.extern.slf4j.Slf4j;


@Slf4j
public class PauseUtils {
    /**
     *
     */

    public static void pause(int timeout){
        try {
            Thread.sleep(timeout);
        }catch (Exception e){
            log.info(e.getMessage());
        }
    }
}
