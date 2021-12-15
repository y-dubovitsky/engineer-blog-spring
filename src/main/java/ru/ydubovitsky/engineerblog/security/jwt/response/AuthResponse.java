package ru.ydubovitsky.engineerblog.security.jwt.response;

public class AuthResponse {

    private String jwttoken;
    private String user;

    public AuthResponse(String jwttoken, String user) {
        this.jwttoken = jwttoken;
        this.user = user;
    }

    public String getJwttoken() {
        return jwttoken;
    }

    public void setJwttoken(String jwttoken) {
        this.jwttoken = jwttoken;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }
}
