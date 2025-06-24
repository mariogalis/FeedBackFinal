package feedback.feedbackfinal.Stark;

import feedback.feedbackfinal.Stark.AnalysisResult;

import java.util.Random;
import java.util.function.Consumer;

public class DataAnalysisTask implements Runnable {

    private final int taskId;
    private final Consumer<AnalysisResult> callback;
    private final Random random = new Random();

    public DataAnalysisTask(int taskId, Consumer<AnalysisResult> callback) {
        this.taskId = taskId;
        this.callback = callback;
    }

    @Override
    public void run() {
        // Simula procesamiento de datos
        long total = 0;
        for (int i = 0; i < 100000 + random.nextInt(50000); i++) {
            total += random.nextInt(100);
        }

        AnalysisResult result = new AnalysisResult(taskId, total, Thread.currentThread().getName());
        callback.accept(result);
    }
}

