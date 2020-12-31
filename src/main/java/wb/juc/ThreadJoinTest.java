package wb.juc;

/**
 * @author bing.wang
 * @date 2020/12/14 11:12
 */
public class ThreadJoinTest {
    public static void main(String[] args) {

        Thread previous = Thread.currentThread();
        for (int i = 0; i < 10; i++) {
            joinThread curThread = new joinThread(previous);
            curThread.start();
            previous=curThread;
        }

    }

    static class joinThread extends Thread{
        private Thread thread;

        public joinThread(Thread thread){
            this.thread=thread;
        }

        @Override
        public void run(){
            try {
                System.out.println(thread.getName());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
