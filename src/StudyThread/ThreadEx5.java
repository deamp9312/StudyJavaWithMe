package StudyThread;

public class ThreadEx5 {
    static long startTime = 0;

    public static void main(String[] args) {
        ThreadEx5_1 th1 = new ThreadEx5_1();
        ThreadEx5_2 th2 = new ThreadEx5_2();

        startTime = System.currentTimeMillis();

        th1.start();
        th2.start();

    }
}

class ThreadEx5_1 extends Thread{
    public void run(){

        for (int i = 0; i < 300; i++) {
            System.out.printf("%s", new String("-"));
        }
        System.out.println("소요시간 1: " + (System.currentTimeMillis() - ThreadEx5.startTime));
    }
}

class ThreadEx5_2 extends Thread{
    public void run(){

        for (int i = 0; i < 300; i++) {
            System.out.printf("%s", new String("|"));
        }
        System.out.println("소요시간 2: " + (System.currentTimeMillis() - ThreadEx5.startTime));
    }
}