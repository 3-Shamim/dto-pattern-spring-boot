package com.learningstuff.dtopatternspringboot.converters;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.learningstuff.dtopatternspringboot.dto.UserDTO;
import com.learningstuff.dtopatternspringboot.models.User;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.function.Function;

/**
 * Created by IntelliJ IDEA.
 * User: Md. Shamim
 * Date: ৩১/৩/২৩
 * Time: ৩:০৪ PM
 * Email: mdshamim723@gmail.com
 */

@Component
@AllArgsConstructor
public class ConverterForUserDTO implements Function<User, UserDTO> {

    private final ObjectMapper objectMapper;

    @Override
    public UserDTO apply(User user) {
        return objectMapper.convertValue(user, UserDTO.class);
    }

}
