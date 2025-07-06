package com.dddn.utils;

public class CurrentLocal {
    private static ThreadLocal<Integer> threadLocal = new ThreadLocal<>();

    public static void setThreadLocal(Integer empId){
        threadLocal.set(empId);
    }

    public static Integer getThreadLocal(){
        return threadLocal.get();
//        return 233;
    }

    public static void remove(){
        threadLocal.remove();
    }
}
