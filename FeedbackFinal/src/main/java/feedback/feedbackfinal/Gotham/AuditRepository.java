package feedback.feedbackfinal.Gotham;

import feedback.feedbackfinal.Gotham.AuditLog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuditRepository extends JpaRepository<AuditLog, Long> {
}

