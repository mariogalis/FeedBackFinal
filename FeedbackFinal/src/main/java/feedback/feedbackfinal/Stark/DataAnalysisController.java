package feedback.feedbackfinal.Stark;

import feedback.feedbackfinal.Stark.AnalysisResult;
import feedback.feedbackfinal.Stark.DataAnalysisService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/stark")
public class DataAnalysisController {

    private final DataAnalysisService service;

    public DataAnalysisController(DataAnalysisService service) {
        this.service = service;
    }

    @GetMapping("/analyze")
    public String simularAnalisis(@RequestParam(defaultValue = "5") int tareas) {
        service.analizarDatosConcurrents(tareas);
        return tareas + " tareas lanzadas.";
    }


    @PostMapping("/analyze")
    public String lanzarAnalisis(@RequestParam(defaultValue = "10") int tareas) {
        service.analizarDatosConcurrents(tareas);
        return tareas + " tareas lanzadas.";
    }

    @GetMapping("/results")
    public List<AnalysisResult> resultados() {
        return service.obtenerResultados().stream().toList();
    }

    @DeleteMapping("/results")
    public String reset() {
        service.reset();
        return "Resultados reiniciados.";
    }
}
