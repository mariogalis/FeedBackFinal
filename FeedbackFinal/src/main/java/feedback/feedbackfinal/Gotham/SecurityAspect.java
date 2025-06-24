package feedback.feedbackfinal.Gotham;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class SecurityAspect {

    private final AuditService auditService;

    public SecurityAspect(AuditService auditService) {
        this.auditService = auditService;
    }

    @Before("execution(* feedback.feedbackfinal.Gotham..*Controller.*(..))")
    public void logAccess(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().toShortString();
        auditService.log(new AuditLog("Access to: " + methodName, "INFO"));
    }
}
