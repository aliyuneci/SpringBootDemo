package com.aliyun.eci.demo.work;

public class CpuConsumer {

    //cpu消耗方法
    public static void consume() {

        long startTime = System.currentTimeMillis();
        long currentTime = System.currentTimeMillis();
        // 持续5s
        while (currentTime - startTime <= 5000) {
            currentTime = System.currentTimeMillis();
            while (System.currentTimeMillis() - currentTime < 20) ;
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}