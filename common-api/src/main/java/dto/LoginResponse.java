package dto;


import lombok.Data;

@Data
public class LoginResponse {

    private String accessToken;
    private String tokenType = "Bearer";

    private LoginResponse(String accessToken) {
        this.accessToken = accessToken;
    }
}
