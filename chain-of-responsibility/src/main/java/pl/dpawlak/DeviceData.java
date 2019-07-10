package pl.dpawlak;

public class DeviceData {

    public enum Status { IN_PROGRESS, MODEL_CHANGE_ERROR }

    public Status status = Status.IN_PROGRESS;
    public boolean licenceChecked;

}
