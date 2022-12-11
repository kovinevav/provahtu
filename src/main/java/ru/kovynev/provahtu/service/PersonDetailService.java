package ru.kovynev.provahtu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.kovynev.provahtu.details.PersonDetails;
import ru.kovynev.provahtu.entities.User;
import ru.kovynev.provahtu.rep.UserRepository;

import java.util.Optional;

@Service
public class
PersonDetailService implements UserDetailsService {
    private final UserRepository userRepository;

    @Autowired
    public PersonDetailService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String userEmail) throws UsernameNotFoundException {
        Optional<User> user = userRepository.findByUserEmail(userEmail);
        if (user.isEmpty()) throw new UsernameNotFoundException("User not found");
        return new PersonDetails(user.get());

    }

}
