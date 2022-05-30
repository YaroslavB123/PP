package lpnu.service;

import lpnu.dto.UserDTO;
import java.util.List;

public interface UserService {
    List<UserDTO> getAllUser();
    UserDTO getUserId(Long id);
    UserDTO updateUser(UserDTO userDTO);
    UserDTO saveUser(UserDTO userDTO);
    void deleteUserId(long id);
}
