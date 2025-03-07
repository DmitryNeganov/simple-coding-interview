package org.dvn.simple_coding_interview.repo;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Long> {
    User getUserById(Long id);
}
