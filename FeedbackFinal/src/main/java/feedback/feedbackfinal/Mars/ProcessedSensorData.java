package feedback.feedbackfinal.Mars;
import feedback.feedbackfinal.Mars.*;
public class ProcessedSensorData {
    private String id;
    private double normalized;

    public ProcessedSensorData(String id, double normalized) {
        this.id = id;
        this.normalized = normalized;
    }

    @Override
    public String toString() {
        return "ProcessedSensorData{" + "id='" + id + '\'' + ", normalized=" + normalized + '}';
    }
}
