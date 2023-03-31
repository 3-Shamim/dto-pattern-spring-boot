package com.learningstuff.dtopatternspringboot.services;

import com.learningstuff.dtopatternspringboot.converters.ConverterForUserDTO;
import com.learningstuff.dtopatternspringboot.dto.UserDTO;
import com.learningstuff.dtopatternspringboot.dto.UserLiteDTO;
import com.learningstuff.dtopatternspringboot.exceptions.NoDataFoundException;
import com.learningstuff.dtopatternspringboot.models.User;
import com.learningstuff.dtopatternspringboot.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by IntelliJ IDEA.
 * User: Md. Shamim
 * Date: ৩১/৩/২৩
 * Time: ৯:৪৭ AM
 * Email: mdshamim723@gmail.com
 */

@AllArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;
    private final ConverterForUserDTO converterForUserDTO;

    public Page<UserDTO> getUsers(PageRequest page) {

        Page<User> users = userRepository.findAll(page);

        List<UserDTO> userDTOS = users.getContent().stream().map(converterForUserDTO).collect(Collectors.toList());

        return new PageImpl<>(
                userDTOS,
                page, users.getTotalElements()
        );
    }

    public UserDTO getUserById(long id) {
        return userRepository.findById(id)
                .map(UserDTO::map)
                .orElseThrow(() -> new NoDataFoundException("User not found by id: " + id));
    }

    public UserLiteDTO getLiteUserById(long id) {
        return userRepository.findById(id)
                .map(UserLiteDTO::map)
                .orElseThrow(() -> new NoDataFoundException("User not found by id: " + id));
    }


}
