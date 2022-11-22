package ru.kovynev.provahtu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.kovynev.provahtu.entities.User;
import ru.kovynev.provahtu.rep.UserRepository;

import javax.transaction.Transactional;

@Service
public class RegistrationService {
    @Autowired
    private final UserRepository userRepository;

    public RegistrationService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    @Transactional
    public void register(User user){
        userRepository.save(user);
    }
}
