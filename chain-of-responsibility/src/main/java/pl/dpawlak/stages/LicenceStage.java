package pl.dpawlak.stages;

import pl.dpawlak.OtherActors;

public class LicenceStage extends Stage {

    @Override
    protected void processIfNoError() {
        try {
            OtherActors.dataExchange.exchange(OtherActors.CHECK_LICENCE);
            waitForResponse();
        } catch(InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void waitForResponse() throws InterruptedException {
        String response = OtherActors.dataExchange.exchange(null);
        if (Boolean.valueOf(response)) {
            System.out.println("Stage: Licence valid, proceeding ...");
            data.licenceChecked = true;
            moveToNextStage();
        } else {
            System.out.println("Stage: Licence NOT valid.");
        }
    }
}
