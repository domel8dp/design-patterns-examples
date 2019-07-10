package pl.dpawlak;

import java.util.Random;
import java.util.concurrent.Exchanger;
import java.util.concurrent.TimeUnit;

public class OtherActors implements Runnable {

    public static final String LOCK_ASDID = "Lock ASDID";
    public static final String CHECK_LICENCE = "Check Licence";
    public static final String CHANGE_MODEL = "Change Model";

    public static final Exchanger<String> dataExchange = new Exchanger<>();

    private final Random rand = new Random();

    @Override
    public void run() {
        System.out.println("Actor: Starting ...");
        try {
            while (!Thread.currentThread().isInterrupted()) {
                String command = dataExchange.exchange(null);
                System.out.println("Actor: received: " + command);
                doWork();
                dataExchange.exchange(String.valueOf(rand.nextBoolean()));
            }
        } catch(InterruptedException e) {
            System.out.println("Actor: Interrupted.");
        }
    }

    private void doWork() throws InterruptedException {
        TimeUnit.SECONDS.sleep(1 + rand.nextInt(5));
    }
}
