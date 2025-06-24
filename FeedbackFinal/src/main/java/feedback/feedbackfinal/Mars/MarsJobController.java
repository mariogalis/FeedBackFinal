package feedback.feedbackfinal.Mars;


import org.springframework.batch.core.*;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/mars")
public class MarsJobController {

    @Autowired
    private JobLauncher jobLauncher;

    @Autowired
    private Job marsSensorJob;

    @GetMapping("/launch")
    public String launchJob() throws Exception {
        JobParameters params = new JobParametersBuilder()
                .addLong("time", System.currentTimeMillis()) // evitar colisiones
                .toJobParameters();

        jobLauncher.run(marsSensorJob, params);
        return "🚀 Job de Marte lanzado correctamente";
    }
}