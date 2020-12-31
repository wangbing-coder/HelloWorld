package wb.juc;


import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author bing.wang
 * @date 2020/12/14 16:42
 */
public class LocksTest {
    public static void main(String[] args) {
        LTest locksTest = new LTest();

        new Thread(locksTest,"Thread-1").start();
        new Thread(locksTest,"Thread-2").start();

        volatileTest volatileTest = new volatileTest();
        //new Thread(volatileTest,"T1").start();
        //new Thread(volatileTest,"T2").start();

    }

}

class LTest implements Runnable{
    private int tick = 10;

    private Lock lock = new ReentrantLock();

    @Override
    public void run() {
        lock.lock();

        try {
            while (true){
                if(tick>0){
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName()+"==="+--tick);
                }
            }
        }finally {
            lock.unlock();
        }
    }
}

class volatileTest implements Runnable{

    private AtomicInteger tick = new AtomicInteger(10);

    @Override
    public void run() {
        while (true){
            if(tick.get()>0){
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName()+"==="+tick.decrementAndGet());
            }
        }
    }
}