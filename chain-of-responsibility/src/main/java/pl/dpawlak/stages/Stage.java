package pl.dpawlak.stages;

import pl.dpawlak.DeviceData;

public abstract class Stage {

    protected Stage nextStage;
    protected DeviceData data;

    public final Stage setBefore(Stage nextStage) {
        this.nextStage = nextStage;
        return nextStage;
    }

    public final void pass(DeviceData data) {
        this.data = data;
        process();
    }

    protected void process() {
        if (data.status == DeviceData.Status.IN_PROGRESS) {
            processIfNoError();
        } else {
            moveToNextStage();
        }
    }

    protected void processIfNoError() { }

    protected final void moveToNextStage() {
        DeviceData dataRef = data;
        data = null;
        if (nextStage != null) {
            nextStage.pass(dataRef);
        }
    }
}
