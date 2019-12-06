import java.sql.SQLOutput;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;

public class PassengerThread extends Thread {
    Semaphore sem;
    CountDownLatch cdl;
    int id;

    PassengerThread (Semaphore sem, CountDownLatch cdl, int id){
        this.sem = sem;
        this.cdl = cdl;
        this.id = id;
    }
    public synchronized void run(){
        try {
            sem.acquire();
            System.out.println("Пассажир " + id + " купил билет");
            sem.release();
            System.out.println("Пассажир " + id + " садится в автобус");
            cdl.countDown();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }



    }
}
