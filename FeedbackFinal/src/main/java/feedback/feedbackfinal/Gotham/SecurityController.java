package feedback.feedbackfinal.Gotham;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SecurityController {

    @GetMapping("/secure")
    public String secureEndpoint() {
        return "Access granted to Gotham.";
    }
}
