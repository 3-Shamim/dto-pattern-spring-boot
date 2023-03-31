package com.learningstuff.dtopatternspringboot.dto;

import com.learningstuff.dtopatternspringboot.models.User;

/**
 * Created by IntelliJ IDEA.
 * User: Md. Shamim
 * Date: ৩১/৩/২৩
 * Time: ২:৫৮ PM
 * Email: mdshamim723@gmail.com
 */

public record UserLiteDTO(long id, String fullName) {

    public static UserLiteDTO map(User user) {
        return new UserLiteDTO(user.getId(), user.getFullName());
    }

}
