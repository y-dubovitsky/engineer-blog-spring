package ru.ydubovitsky.engineerblog.payload.response;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@Data
@AllArgsConstructor
public class JwtResponse implements Serializable {

    private String jwttoken;
    private String username;

}
