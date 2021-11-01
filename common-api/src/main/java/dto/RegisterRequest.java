package dto;

import java.util.Collection;
import java.util.Set;

import lombok.Data;

@Data
public class RegisterRequest {
    private String username;
    private String password;
    private Set<String> roles;
}
