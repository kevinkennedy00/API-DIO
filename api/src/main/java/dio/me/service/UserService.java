package dio.me.service;

import me.dio.model.User;

public interface UserService {
    User findById(Long id);
    User create(User userToCreate);
}
