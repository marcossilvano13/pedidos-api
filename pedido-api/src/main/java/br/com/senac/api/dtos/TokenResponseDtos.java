package br.com.senac.api.dtos;

public class TokenResponseDtos {
    private String token;

    public TokenResponseDtos(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
