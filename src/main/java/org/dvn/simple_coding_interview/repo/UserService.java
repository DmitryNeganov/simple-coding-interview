package org.dvn.simple_coding_interview.repo;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepo userRepo;

    public User getUser(Long id) {
        User user = userRepo.getUserById(id); //finding user by id
        return user;
    }
}
