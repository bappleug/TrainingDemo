package com.tw.apistack;

import java.util.Collection;

public class Utils {

    public static boolean isEmpty(String str){
        return str == null || str.length() == 0;
    }

    public static boolean isEmpty(Collection collection) {
        return collection == null || collection.isEmpty();
    }
}
