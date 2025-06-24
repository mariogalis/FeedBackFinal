package feedback.feedbackfinal.JurassicPark;


import feedback.feedbackfinal.JurassicPark.SensorData;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Random;

@Service
public class SensorService {

    private final String[] dinosaurios = { "T-Rex", "Triceratops", "Velociraptor", "Stegosaurus", "Brachiosaurus" };
    private final Random random = new Random();

    public Flux<SensorData> streamSensores() {
        return Flux.interval(Duration.ofSeconds(1))
                .map(tick -> {
                    String dino = dinosaurios[random.nextInt(dinosaurios.length)];
                    double temp = 35 + random.nextDouble() * 10;
                    double ritmo = 60 + random.nextDouble() * 100;
                    return new SensorData(dino, temp, ritmo, LocalDateTime.now());
                });
    }
}

