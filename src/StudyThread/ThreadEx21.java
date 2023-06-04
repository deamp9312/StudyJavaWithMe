package StudyThread;

public class ThreadEx21 {
    public static int COUNTCHECKNUMBER = 0;
    public static void main(String[] args) {
        Runnable r =  new RunnableEx21();

        new Thread(r).start();
        new Thread(r).start();

    }
}

class Account{
    private int balance =1000;

    public int getBalance(){
        return balance;
    }
    public synchronized void withdraw(int money){
        if(balance >=money){
            try {
                Thread.sleep(1000);
            }catch (Exception e){}
            balance-=money;
        }
    }

}
class RunnableEx21 implements Runnable{
    Account acc = new Account();

    @Override
    public void run() {
        while(acc.getBalance()>0){
            System.out.println("while 실행됨"+ThreadEx21.COUNTCHECKNUMBER++);
            int money = (int) (Math.random() * 3 + 1) * 100;
            System.out.println("money = " + money);
            acc.withdraw(money);
            System.out.println("acc.getBalance() = " + acc.getBalance());
        }
    }
}