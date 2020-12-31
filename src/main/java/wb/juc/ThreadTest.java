package wb.juc;

import java.util.concurrent.*;

/**
 * @author bing.wang
 * @date 2020/12/11 17:59
 */
public class ThreadTest {
    public static void main(String[] args) {
        /*//继承直接执行
        ThreadDemo threadDemo = new ThreadDemo();
        threadDemo.start();

        //传参到Thread类
        Thread thread = new Thread(threadDemo);
        thread.start();

        //实现接口
        RunnableDemo runnableDemo = new RunnableDemo();
        Thread thread1 = new Thread(runnableDemo);
        thread1.start();

        //wb.juc callable
        CallableDemo callableDemo = new CallableDemo();
        FutureTask<Object> objectFutureTask = new FutureTask<Object>(callableDemo);
        Thread thread2 = new Thread(objectFutureTask);
        thread2.start();*/

        Thread sleep = new Thread() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        sleep.start();

        Thread busy = new Thread() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                    System.out.println("aaa");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        busy.start();

        sleep.interrupt();
        busy.interrupt();


        System.out.println(sleep.isInterrupted());
        System.out.println(busy.isInterrupted());

    }
}


class ThreadDemo extends Thread{

    @Override
    public void run() {
        System.out.println("thread");
    }
}

class RunnableDemo implements Runnable{
    @Override
    public void run() {
        System.out.println("runable");
    }
}

class CallableDemo implements Callable{
    @Override
    public Object call() throws Exception {
        return null;
    }
}