package StudyThread;

public class ThreadEx10 implements Runnable{
    static boolean autoSave = false;

    public static void main(String[] args) {
        Thread t = new Thread(new ThreadEx10());
//        t.setDaemon(true);
        t.start();

        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(1000);
            }catch (Exception e){

            }
            System.out.println("i = " + i);
            if(i==5)
                autoSave = true;
        }
        System.out.println("programing is end");

    }

    @Override
    public void run() {
        while(true){
            try {
                Thread.sleep(2 * 1000);
            }catch (Exception e){}
            if(autoSave){
                autoSave();
            }
        }

    }
    public void autoSave(){
        System.out.println("작업파일이 자동저장되어씃비낟.");

    }
}

