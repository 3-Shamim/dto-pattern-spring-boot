package com.learningstuff.dtopatternspringboot.repositories;

import com.learningstuff.dtopatternspringboot.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by IntelliJ IDEA.
 * User: Md. Shamim
 * Date: ৩১/৩/২৩
 * Time: ৯:৩২ AM
 * Email: mdshamim723@gmail.com
 */

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
