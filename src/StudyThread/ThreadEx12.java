package StudyThread;

public class ThreadEx12 {
    public static void main(String[] args) {
        ThreadEx12_1 th1 = new ThreadEx12_1();
        ThreadEx12_2 th2 = new ThreadEx12_2();
        th1.start();
        th2.start();

        try {
//            th1.sleep(2000);
            th1.join(20000);

        } catch (Exception e) {

        }
        System.out.println("main is end!");
    }
}
class ThreadEx12_1 extends Thread{

    public void run() {
        for (int i = 0; i < 300; i++) {
            System.out.print("-");

        }
        System.out.println("1end!!!");
    }
}



class ThreadEx12_2 extends Thread{
    @Override
    public void run() {
        for (int i = 0; i < 300; i++) {
            System.out.print("|");

        }
        System.out.println("2end!!!");
    }
}


