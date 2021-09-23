package course_project.ship.abstracts;

public enum ShipStatus {

    SANK("Sank", 0),
    HEALTHY("Healthy", 1);

    private String status;
    private int value;

    ShipStatus(String status, int value) {
        this.status = status;
        this.value = value;
    }

    public String getStatus() {
        return status;
    }

    public int getValue() {
        return value;
    }
}
