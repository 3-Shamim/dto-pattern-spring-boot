package com.learningstuff.dtopatternspringboot.controllers;

import com.learningstuff.dtopatternspringboot.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Created by IntelliJ IDEA.
 * User: Md. Shamim
 * Date: ৩১/৩/২৩
 * Time: ৯:৫১ AM
 * Email: mdshamim723@gmail.com
 */

@AllArgsConstructor
@RequestMapping(value = "users")
@RestController
public class UserController {

    private final UserService userService;

    @GetMapping(value = "")
    public ResponseEntity<?> getUsers(@RequestParam(value = "page", defaultValue = "0") int page,
                                      @RequestParam(value = "size", defaultValue = "25") int size) {
        PageRequest pageRequest = PageRequest.of(page, size);
        return ResponseEntity.status(HttpStatus.OK).body(userService.getUsers(pageRequest));
    }

    @GetMapping(value = "/id/{id}")
    public ResponseEntity<?> getUserById(@PathVariable(value = "id") long id) {
        return ResponseEntity.status(HttpStatus.OK).body(userService.getUserById(id));
    }

    @GetMapping(value = "/lite/id/{id}")
    public ResponseEntity<?> getLiteUserById(@PathVariable(value = "id") long id) {
        return ResponseEntity.status(HttpStatus.OK).body(userService.getLiteUserById(id));
    }

}
