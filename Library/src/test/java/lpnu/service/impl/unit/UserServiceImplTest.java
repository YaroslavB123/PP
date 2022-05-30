package lpnu.service.impl.unit;

import lpnu.dto.UserDTO;
import lpnu.entity.User;
import lpnu.exception.ServiceException;
import lpnu.mapper.UserToUserDTOMapper;
import lpnu.repository.UserRepository;
import lpnu.service.UserService;
import lpnu.service.impl.UserServiceImpl;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

public class UserServiceImplTest {
    @Test
    public void test_getUserId_userExist() throws Exception {
        final UserRepository userRepository = Mockito.mock(UserRepository.class);
        final UserToUserDTOMapper userMapper = Mockito.mock(UserToUserDTOMapper.class);

        final UserService userService = new UserServiceImpl(userRepository, userMapper);

        final User user = new User(1L, "name", "surname", "email", "number");

        when(userRepository.getUserId(1L)).thenReturn(user);
        when(userMapper.toDTO(any())).thenCallRealMethod();

        final UserDTO userDTO = userService.getUserId(1L);

        assertNotNull(userDTO);
        assertEquals(1L, (long) userDTO.getId());
    }

    @Test
    public void test_getUserId_userNotExist() throws Exception {
        final UserRepository userRepository = Mockito.mock(UserRepository.class);
        final UserToUserDTOMapper userMapper = Mockito.mock(UserToUserDTOMapper.class);

        final UserService userService = new UserServiceImpl(userRepository, userMapper);

        when(userRepository.getUserId(1L)).thenThrow(new ServiceException(400, "error"));
        when(userMapper.toDTO(any())).thenCallRealMethod();

        try {
            final UserDTO userDTO = userService.getUserId(1L);
            fail();
        } catch (final ServiceException e) {

        }
    }

    @Test
    public void test_getAllUser_userExist() throws Exception {
        final UserRepository userRepository = Mockito.mock(UserRepository.class);
        final UserToUserDTOMapper userMapper = Mockito.mock(UserToUserDTOMapper.class);

        final UserService userService = new UserServiceImpl(userRepository, userMapper);
        final List<User> users = new ArrayList<>();
        final User user = new User(1L, "name", "surname", "email", "number");
        users.add(user);

        when(userRepository.getAllUsers()).thenReturn(users);
        when(userMapper.toDTO(any())).thenCallRealMethod();

        final List<UserDTO> userDTO = userService.getAllUser();

        assertNotNull(userDTO);
        assertEquals(1L, (long)users.get(0).getId());
    }

    @Test
    public void test_getAllUser_userNoExist() throws Exception {
        final UserRepository userRepository = Mockito.mock(UserRepository.class);
        final UserToUserDTOMapper userMapper = Mockito.mock(UserToUserDTOMapper.class);

        final UserService userService = new UserServiceImpl(userRepository, userMapper);
        final List<User> users = new ArrayList<>();

        when(userRepository.getAllUsers()).thenReturn(users);
        when(userMapper.toDTO(any())).thenCallRealMethod();

        final List<UserDTO> userDTO = userService.getAllUser();


        assertEquals(userDTO,new ArrayList<>());
    }

    @Test
    public void test_saveUser_userExist() throws Exception {
        final UserRepository userRepository = Mockito.mock(UserRepository.class);
        final UserToUserDTOMapper userMapper = Mockito.mock(UserToUserDTOMapper.class);

        final UserService userService = new UserServiceImpl(userRepository, userMapper);
        final User user = new User(1L, "name", "surname", "email", "number");


        when(userRepository.saveUser(user)).thenReturn(user);
        when(userMapper.toDTO(any())).thenCallRealMethod();

        final UserDTO userDTO = userService.saveUser(userMapper.toDTO(user));

        assertNotNull(userDTO);
        assertEquals("name", userDTO.getName());
    }

    @Test
    public void test_saveUser_userNoExist() throws Exception {
        final UserRepository userRepository = Mockito.mock(UserRepository.class);
        final UserToUserDTOMapper userMapper = Mockito.mock(UserToUserDTOMapper.class);

        final UserService userService = new UserServiceImpl(userRepository, userMapper);


        when(userRepository.saveUser(null)).thenThrow(new ServiceException(400, "user not found"));
        when(userMapper.toDTO(any())).thenCallRealMethod();

        try {
            final UserDTO userDTO = userService.saveUser(null);
            fail();
        } catch (final Exception e) {

        }
    }

    @Test
    public void test_updateUser_userExist() throws Exception {
        final UserRepository userRepository = Mockito.mock(UserRepository.class);
        final UserToUserDTOMapper userMapper = Mockito.mock(UserToUserDTOMapper.class);

        final UserService userService = new UserServiceImpl(userRepository, userMapper);
        final User user = new User(1L, "name", "surname", "email", "number");


        when(userRepository.updateUser(user)).thenReturn(user);
        when(userMapper.toDTO(any())).thenCallRealMethod();

        final UserDTO userDTO = userService.updateUser(userMapper.toDTO(user));

        assertNotNull(userDTO);
        assertEquals("name", userDTO.getName());
    }

    @Test
    public void test_updateUser_userNoExist() throws Exception {
        final UserRepository userRepository = Mockito.mock(UserRepository.class);
        final UserToUserDTOMapper userMapper = Mockito.mock(UserToUserDTOMapper.class);

        final UserService userService = new UserServiceImpl(userRepository, userMapper);


        when(userRepository.updateUser(null)).thenThrow(new ServiceException(400, "user not found"));
        when(userMapper.toDTO(any())).thenCallRealMethod();

        try {
            final UserDTO userDTO = userService.updateUser(null);
            fail();
        } catch (final ServiceException e) {

        }
    }
}

