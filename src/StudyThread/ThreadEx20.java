package StudyThread;

public class ThreadEx20 {
    public static void main(String[] args) {
        ThreadEx20_1 gc = new ThreadEx20_1();
        gc.setDaemon(true);
        gc.start();

        System.out.println(gc.freeMemory());
        int requiredMemory = 0;
        for(int i=0;i<20;i++){
            System.out.println("i = " + i);

            requiredMemory = (int) (Math.random() * 10) * 20;
            System.out.println("requiredMemory = " + requiredMemory);

            if(gc.totalMemory()<gc.usedMemory || gc.freeMemory()<gc.totalMemory()*0.4){
                System.out.println("if문 실행됨");
                gc.interrupt();
            }
            gc.usedMemory += requiredMemory;
            System.out.println("gc.usedMemory = " + gc.usedMemory);

        }
    }
}
class ThreadEx20_1 extends Thread{
    final static int MAX_MEMORY = 1000;
    int usedMemory = 0;

    @Override
    public void run() {
        while(true){
            try{
                Thread.sleep(10 * 1000);
            }catch (Exception e){
                System.out.println("Awaken by interrupt () .");
            }
            gc();
            System.out.println("Garbage Collected. Free Memory :"+freeMemory());
        }
    }
    public void gc(){
        usedMemory -=300;
        if(usedMemory<0)
            usedMemory=0;
    }
    public int totalMemory(){
        return MAX_MEMORY;
    }
    public int freeMemory(){
        return MAX_MEMORY - usedMemory;
    }
}
