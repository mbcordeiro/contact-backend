package com.matheuscordeiro.contact.services.interfaces;

import com.matheuscordeiro.contact.models.User;

import java.util.Optional;

public interface IUserService {
    User authenticate(String username, String password);

    User saveUser(User user);

    Optional<User> getByUser(Long id);
}
