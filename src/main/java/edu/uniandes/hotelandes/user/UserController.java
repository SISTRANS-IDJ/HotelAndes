package edu.uniandes.hotelandes.user;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/user")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService){
        this.userService = userService;
    }

    @PostMapping
    public void createUser(@RequestBody User user){
        userService.createUser(user);
    }

    @GetMapping("{id}")
    public User getUserId(@PathVariable("id") Short id){
        return userService.getUser(id);
    }

    @GetMapping
    public List<User> listUsers(){
        return userService.getUsers();
    }

    @PutMapping("{id}")
    public User updateUser(@PathVariable Short id, @RequestBody User user){
        return userService.updateUser(id, user);
    }

    @DeleteMapping("{id}")
    public void deleteUser(@PathVariable("id") Short id){
        userService.deleteUser(id);
    }
}
