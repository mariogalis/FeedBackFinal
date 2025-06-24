package feedback.feedbackfinal.Stark;

import feedback.feedbackfinal.Stark.AnalysisResult;
import feedback.feedbackfinal.Stark.DataAnalysisTask;
import org.springframework.stereotype.Service;

import java.util.Queue;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class DataAnalysisService {

    private final ExecutorService executor = Executors.newFixedThreadPool(4);
    private final Queue<AnalysisResult> results = new ConcurrentLinkedQueue<>();
    private final AtomicInteger taskCounter = new AtomicInteger();

    public void analizarDatosConcurrents(int cantidad) {
        for (int i = 0; i < cantidad; i++) {
            int taskId = taskCounter.incrementAndGet();
            executor.submit(new DataAnalysisTask(taskId, results::add));
        }
    }

    public Queue<AnalysisResult> obtenerResultados() {
        return results;
    }

    public void reset() {
        results.clear();
        taskCounter.set(0);
    }
}
