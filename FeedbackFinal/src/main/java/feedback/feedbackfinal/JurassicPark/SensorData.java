package feedback.feedbackfinal.JurassicPark;

import java.time.LocalDateTime;

public class SensorData {

    private String dinosaurio;
    private double temperatura;
    private double frecuenciaCardiaca;
    private LocalDateTime timestamp;

    public SensorData(String dinosaurio, double temperatura, double frecuenciaCardiaca, LocalDateTime timestamp) {
        this.dinosaurio = dinosaurio;
        this.temperatura = temperatura;
        this.frecuenciaCardiaca = frecuenciaCardiaca;
        this.timestamp = timestamp;
    }

    public String getDinosaurio() {
        return dinosaurio;
    }

    public double getTemperatura() {
        return temperatura;
    }

    public double getFrecuenciaCardiaca() {
        return frecuenciaCardiaca;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }
}
