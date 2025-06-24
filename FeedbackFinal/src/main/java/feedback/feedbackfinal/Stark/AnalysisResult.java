package feedback.feedbackfinal.Stark;


public class AnalysisResult {
    private int taskId;
    private long processedData;
    private String threadName;

    public AnalysisResult(int taskId, long processedData, String threadName) {
        this.taskId = taskId;
        this.processedData = processedData;
        this.threadName = threadName;
    }

    public int getTaskId() { return taskId; }
    public long getProcessedData() { return processedData; }
    public String getThreadName() { return threadName; }
}
