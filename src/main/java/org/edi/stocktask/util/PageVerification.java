package org.edi.stocktask.util;

/**
 * Created by asus on 2018/8/3.
 */
public class PageVerification {
    public static int limitCalculation(int beginIndex,int limit){
        if(beginIndex==0){
            beginIndex=1;
        }
        if(limit==0){
            limit=20;
        }
        limit = beginIndex+limit-1;
        return limit;
    }
}
