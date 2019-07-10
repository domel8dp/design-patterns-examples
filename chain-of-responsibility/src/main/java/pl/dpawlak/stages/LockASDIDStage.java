package pl.dpawlak.stages;

import pl.dpawlak.OtherActors;

public class LockASDIDStage extends Stage {

    @Override
    protected void processIfNoError() {
        try {
            OtherActors.dataExchange.exchange(OtherActors.LOCK_ASDID);
            waitForResponse();
        } catch(InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void waitForResponse() throws InterruptedException {
        String ignored = OtherActors.dataExchange.exchange(null);
        System.out.println("Stage: ASDID locked, proceeding ...");
        moveToNextStage();
    }
}
