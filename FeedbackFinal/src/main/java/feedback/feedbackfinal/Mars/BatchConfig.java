package feedback.feedbackfinal.Mars;

import feedback.feedbackfinal.Mars.*;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.support.ListItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;

import java.util.List;

@Configuration
public class BatchConfig {

    @Bean
    public ListItemReader<SensorData> reader() {
        return new ListItemReader<>(List.of(
                new SensorData("sensor-1", 34.5),
                new SensorData("sensor-2", 22.1),
                new SensorData("sensor-3", 42.7)
        ));
    }

    @Bean
    public SensorDataProcessor processor() {
        return new SensorDataProcessor();
    }

    @Bean
    public ItemWriter<ProcessedSensorData> writer() {
        return items -> items.forEach(System.out::println);
    }

    @Bean
    public Step step(JobRepository jobRepository,
                     PlatformTransactionManager transactionManager) {
        return new StepBuilder("step1", jobRepository)
                .<SensorData, ProcessedSensorData>chunk(2, transactionManager)
                .reader(reader())
                .processor(processor())
                .writer(writer())
                .build();
    }

    @Bean
    public Job job(JobRepository jobRepository, Step step) {
        return new JobBuilder("marsSensorJob", jobRepository)
                .start(step)
                .build();
    }
}
