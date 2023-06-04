package StudyThread;

import java.util.ArrayList;

public class ThreadWaitEx3 {

    public static void main(String[] args) throws Exception{
        Table3 table = new Table3();

        new Thread(new Cook3(table), "COOK1").start();
        new Thread(new Customer3(table, "donut"), "CUST1_donut").start();
        new Thread(new Customer3(table, "burger"), "CUST2_buger").start();

        Thread.sleep(2000);
        System.exit(0);


    }
}
class Customer3 implements Runnable{
    private Table3  table;
    private String food;

    public Customer3(Table3 table, String food) {
        this.table = table;
        this.food = food;
    }

    @Override
    public void run() {
        while (true){
            try {Thread.sleep(100);}catch (Exception e){e.printStackTrace();}
            String name = Thread.currentThread().getName();

            table.remove(food);
            System.out.println(name + " ate a " + food);

        }
    }
//    boolean eatFood(){
//        return table.remove(food);
//    }
}


class Cook3 implements Runnable{
    private Table3 table;
    Cook3(Table3 table){this.table = table;}

    @Override
    public void run() {
        while(true){
            int idx = (int) (Math.random() * table.dishNum());
            table.add(table.dishNames[idx]);
            try {
                Thread.sleep(100);

            }catch (Exception e){}
        }
    }
}


class Table3 {
    String[] dishNames = {"donut", "donut", "burger"};
    final int MAX_FOOD = 6;
    private ArrayList<String> dishes = new ArrayList<>();

    public synchronized void add(String dish){
        while(dishes.size()>=MAX_FOOD){
            String name = Thread.currentThread().getName();
            System.out.println(name + " is waiting . ");
            try {
                wait();
                Thread.sleep(500);
            }catch (Exception e){}
        }
        dishes.add(dish);
        notify();
        System.out.println("dishes.toString() = " + dishes.toString());
    }
    public synchronized void remove(String dishName){
        String name = Thread.currentThread().getName();

        while (dishes.size() == 0) {
                System.out.println(name + "is waiting .");
                try {
                    wait();
                    Thread.sleep(500);
                } catch (Exception e) {
                }
        }
        while (true){
            for (int i = 0; i <dishes.size(); i++) {
                if (dishName.equals(dishes.get(i))) {
                    dishes.remove(i);
                    notify();
                    return ;
                }
            }
            try {
                System.out.println(name + " is waiting.");
                wait();
                Thread.sleep(500);
            }catch (Exception e){}
        }
    }
    public int dishNum(){
        return dishNames.length;
    }
}