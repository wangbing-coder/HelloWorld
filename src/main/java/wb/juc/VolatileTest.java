package wb.juc;

/**
 * @author bing.wang
 * @date 2020/12/11 15:52
 */
public class VolatileTest {


    /**
     * 共享变量 flag
     */
    public static void main(String[] args) {
        //调用线程
        ThreadDemo td = new ThreadDemo();
        new Thread(td).start();

        //主线程
        while (true){
            if(td.isFlag()){
                System.out.println("====="+td.isFlag());
                break;
            }
        }


    }

    static class ThreadDemo implements Runnable{

        private  boolean flag=false;

        @Override
        public void run() {
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            flag=true;
            System.out.println("flag="+flag);
        }

        public boolean isFlag(){
            return flag;
        }

        public void setFlag(boolean flag){
            this.flag=flag;
        }

    }

}
