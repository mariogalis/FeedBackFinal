package feedback.feedbackfinal.Mars;

import feedback.feedbackfinal.Mars.*;

public class SensorData {
    private String id;
    private double value;

    public SensorData(String id, double value) {
        this.id = id;
        this.value = value;
    }

    public String getId() {
        return id;
    }

    public double getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "SensorData{" + "id='" + id + '\'' + ", value=" + value + '}';
    }
}
