package com.learningstuff.dtopatternspringboot.models;

import com.learningstuff.dtopatternspringboot.enums.Gender;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Created by IntelliJ IDEA.
 * User: Md. Shamim
 * Date: ৩১/৩/২৩
 * Time: ৮:৩২ AM
 * Email: mdshamim723@gmail.com
 */


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;
    private String fullName;
    private int age;
    private Gender gender;
    private String secret;

}
