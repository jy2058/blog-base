package me.jiyeon.kim.blogbase.service;

import lombok.RequiredArgsConstructor;
import me.jiyeon.kim.blogbase.Repository.UserRepository;
import me.jiyeon.kim.blogbase.domain.User;
import me.jiyeon.kim.blogbase.dto.AddUserRequest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserService {
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public Long save(AddUserRequest dto) {
        return userRepository.save(User.builder()
                .email(dto.getEmail())
                .password(bCryptPasswordEncoder.encode(dto.getPassword()))
                .build()).getId();

    }
}
