package ru.ydubovitsky.engineerblog.payload.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import ru.ydubovitsky.engineerblog.dto.UserDto;

import java.io.Serializable;

@Data
@AllArgsConstructor
public class JwtResponse implements Serializable {

    private String jwttoken;

    @JsonProperty("user")
    private UserDto userDto;

}
