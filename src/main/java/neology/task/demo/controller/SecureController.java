package neology.task.demo.controller;

import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SecureController {

    @Secured("ROLE_READ")
    @GetMapping("/secure/read")
    public String readMethod() {
        return "This is a READ method";
    }

    @Secured("ROLE_WRITE")
    @GetMapping("/secure/write")
    public String writeMethod() {
        return "This is a WRITE method";
    }

    @PreAuthorize("hasAnyRole('WRITE', 'DELETE')")
    @GetMapping("/secure/write-or-delete")
    public String writeOrDeleteMethod() {
        return "This is a WRITE or DELETE method";
    }

    @GetMapping("/secure/check-username")
    public String checkUsername(@RequestParam String username) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && authentication.getName().equals(username)) {
            return "Username matches: " + username;
        } else {
            return "Username does not match";
        }
    }
}