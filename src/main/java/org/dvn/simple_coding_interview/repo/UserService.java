package org.dvn.simple_coding_interview.repo;

import org.springframework.stereotype.Service;

@Service
public class UserService {

    public User getUser(Long id) {
        User user = new User(); //finding user by id
        return user;
    }
}
