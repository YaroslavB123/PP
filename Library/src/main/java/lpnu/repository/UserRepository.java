package lpnu.repository;

import lpnu.entity.User;
import lpnu.exception.ServiceException;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class UserRepository {
    private List<User> users = new ArrayList<>();
    private long id = 1;

    public List<User> getAllUsers() {
        return users;
    }

    public User getUserId(final Long id) {
        return users.stream()
                .filter(e -> e.getId().equals(id))
                .findFirst()
                .orElseThrow(()-> new ServiceException(400, "user with id {" + id + "} not found"));
    }

    public User updateUser(final User user) {
        if (user == null)
            throw  new ServiceException(400, "user is null");

        final User savedUser = getUserId(user.getId());

        savedUser.setId(user.getId());
        savedUser.setName(user.getName());
        savedUser.setSurname(user.getSurname());
        savedUser.setEmail(user.getEmail());
        savedUser.setPhoneNumber(user.getPhoneNumber());

        return savedUser;
    }

    public User saveUser(final User user) {
        if (user == null)
            throw  new ServiceException(400, "user is null");

        user.setId(id++);
        users.add(user);

        return user;
    }

    public void deleteUserId(final long id) {
        users = users.stream()
                .filter(user -> user.getId() != id)
                .collect(Collectors.toList());
    }
}
