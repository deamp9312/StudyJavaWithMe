package StudyThread;

import javax.swing.*;

public class ThreadEx13 {
    public static void main(String[] args) {
        ThreadEx13_1 th1 = new ThreadEx13_1();
        th1.start();
//        System.out.println("th1.isInterrupted() = " + th1.isInterrupted());
        Boolean bol = th1.isInterrupted();
        String input = JOptionPane.showInputDialog("아무 값이나 입력하세요.");
        System.out.println("input = " + input);
        th1.interrupt();
        System.out.println("th1.isInterrupted() = " + th1.isInterrupted());
        System.out.println("bol = " + bol);
    }
}

class ThreadEx13_1 extends Thread {

    public void run() {
        int i=1000000;

        while (i != 0 && !isInterrupted()) {
            System.out.println(i--);

        }
        System.out.println("count is end!");
    }
}