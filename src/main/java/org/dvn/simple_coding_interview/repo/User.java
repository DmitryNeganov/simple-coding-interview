package org.dvn.simple_coding_interview.repo;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class User {
    @Id
    public Long id;
    public String username;
    public String email;
    public String password;
}
