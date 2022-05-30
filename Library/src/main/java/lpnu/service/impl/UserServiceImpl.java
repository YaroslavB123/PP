package lpnu.service.impl;

import lpnu.dto.UserDTO;
import lpnu.entity.User;
import lpnu.exception.ServiceException;
import lpnu.mapper.UserToUserDTOMapper;
import lpnu.repository.UserRepository;
import lpnu.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserToUserDTOMapper userDTOMapper;

    public UserServiceImpl(final UserRepository userRepository, final UserToUserDTOMapper userDTOMapper) {
        this.userRepository = userRepository;
        this.userDTOMapper = userDTOMapper;
    }

    @Override
    public List<UserDTO> getAllUser() {
        return userRepository.getAllUsers().stream()
                .map(userDTOMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public UserDTO getUserId(final Long id) {
        return userDTOMapper.toDTO(userRepository.getUserId(id));
    }

    @Override
    public UserDTO updateUser(final UserDTO userDTO) {
        if (userDTO == null)
            throw  new ServiceException(400, "user is null");

        final User user = userDTOMapper.toEntity(userDTO);
        userRepository.updateUser(user);
        return userDTO;
    }

    @Override
    public UserDTO saveUser(final UserDTO userDTO) {
        if (userDTO == null)
            throw  new ServiceException(400, "user is null");

        final User user = userDTOMapper.toEntity(userDTO);
        userRepository.saveUser(user);
        return userDTO;
    }

    @Override
    public void deleteUserId(final long id) {
        userRepository.deleteUserId(id);
    }

}
