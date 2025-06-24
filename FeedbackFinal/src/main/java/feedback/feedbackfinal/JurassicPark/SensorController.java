package feedback.feedbackfinal.JurassicPark;

import feedback.feedbackfinal.JurassicPark.SensorData;
import feedback.feedbackfinal.JurassicPark.SensorService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
public class SensorController {

    private final SensorService service;

    public SensorController(SensorService service) {
        this.service = service;
    }

    @GetMapping(value = "/jurassic/stream", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<SensorData> stream() {
        return service.streamSensores();
    }
}

