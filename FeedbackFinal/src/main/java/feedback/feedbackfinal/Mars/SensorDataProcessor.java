package feedback.feedbackfinal.Mars;


import feedback.feedbackfinal.Mars.*;

import org.springframework.batch.item.ItemProcessor;

public class SensorDataProcessor implements ItemProcessor<SensorData, ProcessedSensorData> {
    @Override
    public ProcessedSensorData process(SensorData item) {
        double normalized = item.getValue() / 100.0;
        return new ProcessedSensorData(item.getId(), normalized);
    }
}
