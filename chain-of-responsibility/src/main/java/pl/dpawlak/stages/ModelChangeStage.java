package pl.dpawlak.stages;

import pl.dpawlak.DeviceData;
import pl.dpawlak.OtherActors;

public class ModelChangeStage extends Stage {

    @Override
    protected void processIfNoError() {
        try {
            OtherActors.dataExchange.exchange(OtherActors.CHANGE_MODEL);
            waitForResponse();
        } catch(InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void waitForResponse() throws InterruptedException {
        String response = OtherActors.dataExchange.exchange(null);
        if (Boolean.valueOf(response)) {
            System.out.println("Stage: Model changed, proceeding ...");
        } else {
            System.out.println("Stage: Model not changed, proceeding ...");
            data.status = DeviceData.Status.MODEL_CHANGE_ERROR;
        }
        moveToNextStage();
    }
}
