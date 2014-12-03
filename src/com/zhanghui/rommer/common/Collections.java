package com.zhanghui.rommer.common;

import java.util.Collection;

public final class Collections {
    public static boolean contains(Collection col, Object key){
        if(col==null || col.isEmpty() || key == null){
            return false;
        }
        return col.contains(key);
    }
}
