package com.learningstuff.dtopatternspringboot.enums;

import java.util.Random;

/**
 * Created by IntelliJ IDEA.
 * User: Md. Shamim
 * Date: ৩১/৩/২৩
 * Time: ৯:২৫ AM
 * Email: mdshamim723@gmail.com
 */

public enum Gender {

    MALE, FEMALE;

    public static Gender getRandomGender() {
        Random random = new Random();
        return Gender.values()[random.nextInt(Gender.values().length)];
    }

}
