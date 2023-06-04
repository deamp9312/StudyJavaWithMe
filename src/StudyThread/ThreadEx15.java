package StudyThread;

public class ThreadEx15 {
    public static void main(String[] args) {
        RunImplEx15 r = new RunImplEx15();
        Thread th1 = new Thread(r, "*");
        Thread th2 = new Thread(r, "**");
        Thread th3 = new Thread(r, "***");
        th1.start();
        th2.start();
        th3.start();

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
            th1.stop();
            th2.stop();
            System.out.println("=============5");
            Thread.sleep(2000);
            th3.stop();

        }catch (Exception e){}


        System.out.println("main is end!!!");
    }
}

class RunImplEx15 implements Runnable{
    @Override
    public void run() {
        while (true) {
            System.out.println(Thread.currentThread().getName());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {

            }
        }
    }
}