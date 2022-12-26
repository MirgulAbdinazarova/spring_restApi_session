package com.example.spring_restapi_session.service.impl;

import com.example.spring_restapi_session.dto.RegisterRequest;
import com.example.spring_restapi_session.dto.RegisterResponse;
import com.example.spring_restapi_session.entity.User;
import com.example.spring_restapi_session.repo.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService  implements UserDetailsService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    private User mapToEntity(RegisterRequest request) {
        User user =new User();
        user.setEmail(request.getEmail());
        user.setFirsName(request.getFirstName());
        user.setPassword(request.getPassword());
        return user;
    }

    private RegisterResponse mapToResponse(User user) {
        if(user == null) {
            return null;
        }
        RegisterResponse response= new RegisterResponse();
        if(user.getId() != null) {
            response.setId(String.valueOf(user.getId()));
        }
        response.setEmail(user.getEmail());
        response.setFirstName(user.getFirsName());
        return response;

    }

    public  RegisterResponse create(RegisterRequest request) {
        User user= mapToEntity(request);
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        userRepository.save(user);
        return mapToResponse(user);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByEmail(username).orElseThrow(()->
                new UsernameNotFoundException("not found email"));
    }
}
