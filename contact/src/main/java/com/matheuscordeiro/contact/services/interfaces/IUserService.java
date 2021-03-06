package com.matheuscordeiro.contact.services.interfaces;

import com.matheuscordeiro.contact.models.User;

import java.util.Optional;

public interface IUserService {
    User authenticateOrThrow(String username, String password);

    User authenticate(String username, String password);

    User saveUserOrThrow(User user);

    User saveUser(User user);

    Optional<User> getByUser(Long id);
}
