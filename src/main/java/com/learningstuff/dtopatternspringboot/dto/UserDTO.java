package com.learningstuff.dtopatternspringboot.dto;

import com.learningstuff.dtopatternspringboot.enums.Gender;
import com.learningstuff.dtopatternspringboot.models.User;

/**
 * Created by IntelliJ IDEA.
 * User: Md. Shamim
 * Date: ৩১/৩/২৩
 * Time: ২:৫৮ PM
 * Email: mdshamim723@gmail.com
 */

public record UserDTO(long id, String fullName, int age, Gender gender) {

    public static UserDTO map(User user) {
        return new UserDTO(user.getId(), user.getFullName(), user.getAge(), user.getGender());
    }

}
