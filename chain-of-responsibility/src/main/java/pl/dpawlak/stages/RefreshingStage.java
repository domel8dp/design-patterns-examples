package pl.dpawlak.stages;

public class RefreshingStage extends Stage {

    @Override
    public void process() {
        System.out.println("Stage: Sending response - " + data.status + ", proceeding ...");
    }
}
