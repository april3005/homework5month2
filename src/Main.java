import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;

public class Main {


    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(100);
        Semaphore semaphore = new Semaphore(4);

        for (int i = 1; i <= 100 ; i++) {
            PassengerThread passenger = new PassengerThread(semaphore, countDownLatch, i);
            passenger.start();
        }
        countDownLatch.await();
        System.out.println("Поехали");
    }
}
