package com.chengxiang.learn.base;

import java.util.concurrent.FutureTask;

public class CreateThread {
    public static volatile int cnt = 0;

    public static void main(String[] args) {
        new Thread() {
            @Override
            public void run() {
                System.out.println("继承Threa类创建线程任务");
            }
        }.start();


        new Thread(() -> System.out.println("实现Runable接口创建线程")).start();

        //
        new Thread(() -> {
            while (true) {
                if (cnt % 2 == 0 && cnt < 1000) {
                    cnt ++;
                    System.out.println(cnt);
                }
            }
        }).start();

        new Thread(() -> {
            while (true) {
                while (cnt % 2 != 0 && cnt < 1000) {
                    cnt ++;
                    System.out.println(cnt);
                }
            }
        }).start();

        FutureTask<String> stringFutureTask = new FutureTask<>(() -> {
            System.out.println("实现callable接口创建线程");
            return "Success";
        });
        new Thread(stringFutureTask).start();
    }
}
