package feedback.feedbackfinal.Gotham;



import feedback.feedbackfinal.Gotham.*;
import org.springframework.stereotype.Service;
import java.util.concurrent.locks.ReentrantLock;

@Service
public class AuditService {

    private final AuditRepository auditRepository;
    private final ReentrantLock lock = new ReentrantLock();

    public AuditService(AuditRepository auditRepository) {
        this.auditRepository = auditRepository;
    }

    public void log(AuditLog log) {
        lock.lock();
        try {
            auditRepository.save(log); // Guarda en la base de datos
        } finally {
            lock.unlock();
        }
    }
}

