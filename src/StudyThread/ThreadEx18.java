package StudyThread;

public class ThreadEx18 {
    public static void main(String[] args) {

        ThreadEx18_1 th1 = new ThreadEx18_1("*");
        ThreadEx18_1 th2 = new ThreadEx18_1("**");
        ThreadEx18_1 th3 = new ThreadEx18_1("***");

        th1.startThread();
        th2.startThread();
        th3.startThread();

        try {
            System.out.println("=============1");
            Thread.sleep(2000);
            th1.suspend();  //일시 정지한다.
            System.out.println("=============2");
            Thread.sleep(2000);
            th2.suspend();
            System.out.println("=============3");
            Thread.sleep(2000);
            th1.resume();   //정지한거 재기동 시킨다.
            System.out.println("=============4");
            Thread.sleep(3000);
            th1.stopThread();
//            r1.stopThread();
            th2.stopThread();
            System.out.println("=============5");
            Thread.sleep(2000);
            th3.stopThread();

        }catch (Exception e){e.printStackTrace();}


        System.out.println("main is end!!!");
    }

}

class ThreadEx18_1 implements Runnable{
    volatile boolean suspended = false;
    volatile boolean stopped = false;

    Thread th;
    ThreadEx18_1(String name){
        th = new Thread(this, name);
    }


    public void run() {
        String name = th.getName();
        while (!stopped) {
            if(!suspended) {
                System.out.println(Thread.currentThread().getName());
                try {
                    Thread.sleep(1000);
                } catch (Exception e) {
                    System.out.println(name + " - interrupted");

                }
            }else{
                Thread.yield();
            }
        }
        System.out.println(Thread.currentThread().getName() + " - stopped");

    }
    public void suspend(){
        suspended = true;
//        th.interrupt();
        System.out.println(th.getName() + " - interrupt() by suspend()");

    }
    public void stopThread(){
        stopped=true;
//        th.interrupt();
        System.out.println(th.getName() + " - interrupt() by stopThread()");
    }

    public void resume(){
        suspended = false;
    }
    public void startThread(){
        th.start();
    }

}