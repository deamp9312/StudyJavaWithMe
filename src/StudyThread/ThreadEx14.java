package StudyThread;

import javax.swing.*;

public class ThreadEx14 {
    public static void main(String[] args) {
        ThreadEx14_1 th1 = new ThreadEx14_1();
        th1.start();

        String input = JOptionPane.showInputDialog("아무 값이나 입력하세요.");
        System.out.println("input = " + input);
        th1.interrupt();
        System.out.println("th1.isInterrupted() = " + th1.isInterrupted());

    }
}

class ThreadEx14_1 extends Thread {

    public void run() {
        int i=10;

        while (i != 0 && !isInterrupted()) {
            System.out.println(i--);
            try {
                Thread.sleep(1_000);
            } catch (InterruptedException e) {
                interrupt();
                /**
                 * 오류발생으로인해 interrupted 상태가 false로 자동 초기화 되어버림.
                 */
            }

        }
        System.out.println("count is end!");
    }
}