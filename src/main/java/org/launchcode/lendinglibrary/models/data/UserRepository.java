package org.launchcode.lendinglibrary.models.data;

import org.launchcode.lendinglibrary.models.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User,Integer> {

    User findByUsername(String username);
}
