package me.dio.UserServiceImple;

import java.util.NoSuchElementException;

import org.springframework.stereotype.Service;

import dio.me.service.UserService;
import me.dio.model.User;
import me.dio.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {
    
    private final UserRepository userRepository;
    
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    
    @Override
    public User findById(Long id) {
        return userRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    @Override
    public User create(User userToCreate) {
        if (userRepository.existsByAccountNumber(userToCreate.getAccount().getNumber())) {
            throw new IllegalArgumentException("This user ID already exists");
        }
        return userRepository.save(userToCreate);
    }
}
