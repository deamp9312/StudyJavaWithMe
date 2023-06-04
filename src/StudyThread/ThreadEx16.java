package StudyThread;

public class ThreadEx16 {
    public static void main(String[] args) {
        RunImplEx16 r1 = new RunImplEx16();
        RunImplEx16 r2 = new RunImplEx16();
        RunImplEx16 r3 = new RunImplEx16();
        Thread th1 = new Thread(r1, "*");
        Thread th2 = new Thread(r2, "**");
        Thread th3 = new Thread(r3, "***");


        th1.start();
        th2.start();
        th3.start();

        try {
            System.out.println("=============1");
            Thread.sleep(2000);
            r1.suspend();  //일시 정지한다.
            System.out.println("=============2");
            Thread.sleep(2000);
            r2.suspend();
            System.out.println("=============3");
            Thread.sleep(2000);
            r1.resume();   //정지한거 재기동 시킨다.
            System.out.println("=============4");
            Thread.sleep(3000);
            r1.stopThread();
//            r1.stopThread();
            r2.stopThread();
            System.out.println("=============5");
            Thread.sleep(2000);
            r3.stopThread();

        }catch (Exception e){e.printStackTrace();}


        System.out.println("main is end!!!");
    }

}

class RunImplEx16 implements Runnable{
    volatile boolean suspended = false;
    volatile boolean stopped = false;

    public void run() {
        while (!stopped) {
            if(!suspended) {
                System.out.println(Thread.currentThread().getName());
                try {
                    Thread.sleep(1000);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        System.out.println(Thread.currentThread().getName() + " - stopped");

    }
    public void suspend(){
        suspended = true;
    }
    public void resume(){
        suspended = false;
    }
    public void stopThread(){
        stopped=true;
    }
}