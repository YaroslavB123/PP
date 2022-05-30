package lpnu.resourse;

import lpnu.dto.UserDTO;
import lpnu.service.UserService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserResource {

    private final UserService userService;

    public UserResource(final UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public List<UserDTO> getAllUser(){
        return userService.getAllUser();
    }

    @GetMapping("/users/{id}")
    public UserDTO getUserId(@PathVariable @Validated final Long id){
        return userService.getUserId(id);
    }


    @PostMapping("/users")
    public UserDTO saveUser(@RequestBody @Validated final UserDTO userDTO){
        return userService.saveUser(userDTO);
    }

    @PutMapping("/users")
    public UserDTO updateUser(@RequestBody @Validated final UserDTO userDTO){
        return userService.updateUser(userDTO);
    }

    @DeleteMapping("/users/{id}")
    public void deleteUserId(@PathVariable @Validated final long id){
        userService.deleteUserId(id);
    }
}
