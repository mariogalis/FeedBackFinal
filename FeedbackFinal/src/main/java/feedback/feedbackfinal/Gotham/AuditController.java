package feedback.feedbackfinal.Gotham;

import feedback.feedbackfinal.Gotham.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AuditController {

    private final AuditRepository auditRepository;

    public AuditController(AuditRepository auditRepository) {
        this.auditRepository = auditRepository;
    }

    @GetMapping("/audit/Gothamlogs")
    public List<AuditLog> getAllLogs() {
        return auditRepository.findAll();
    }
}
