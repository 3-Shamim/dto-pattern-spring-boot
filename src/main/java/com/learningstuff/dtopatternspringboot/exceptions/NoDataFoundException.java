package com.learningstuff.dtopatternspringboot.exceptions;

/**
 * Created by IntelliJ IDEA.
 * User: Md. Shamim
 * Date: ৩১/৩/২৩
 * Time: ৯:৫৬ AM
 * Email: mdshamim723@gmail.com
 */

public class NoDataFoundException extends RuntimeException {

    public NoDataFoundException(String message) {
        super(message);
    }

}
