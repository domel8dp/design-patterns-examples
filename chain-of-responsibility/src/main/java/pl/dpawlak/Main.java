package pl.dpawlak;

import pl.dpawlak.stages.*;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    public static void main(String[] args) {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        executor.submit(new OtherActors());

        new Main().run();

        executor.shutdownNow();
    }

    private void run() {
        Stage start = arrangeStages();

        DeviceData data = new DeviceData();
        System.out.println("Client: Submitting data ...");
        start.pass(data);
        System.out.println("Client: Data processed.");
    }

    private Stage arrangeStages() {
        Stage start = new LockASDIDStage();
        start
                .setBefore(new ModelChangeStage())
                .setBefore(new LicenceStage())
                .setBefore(new RefreshingStage());
        return start;
    }
}
