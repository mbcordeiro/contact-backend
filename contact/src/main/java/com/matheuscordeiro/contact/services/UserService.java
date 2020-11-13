package com.matheuscordeiro.contact.services;

import com.matheuscordeiro.contact.exceptions.AuthenticationErrorException;
import com.matheuscordeiro.contact.models.User;
import com.matheuscordeiro.contact.repositories.UserRepository;
import com.matheuscordeiro.contact.services.interfaces.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService implements IUserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public User authenticate(String username, String password) {
        Optional<User> user = userRepository.findByUsername(username);

        if (!user.isPresent())
            throw new AuthenticationErrorException("Usuário infromado não encontrado");
        if (!user.get().getPassword().equals(password))
            throw new AuthenticationErrorException("Senha inromada não encontrada");
        return user.get();
    }

    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public Optional<User> getByUser(Long id) {
        return userRepository.findById(id);
    }
}
