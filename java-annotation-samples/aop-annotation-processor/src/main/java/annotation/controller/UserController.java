package annotation.controller;
import annotation.model.entity.User;
import annotation.service.UserRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/user", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class UserController {
    @Autowired
    private UserRepositoryImpl userRepository;

    @PostMapping(value = "/getUsersByIds")
    public List<User> getUsersByIds(@RequestBody String [] ids){
        return userRepository.findUserByIds(ids);
    }

    @GetMapping(value = "/init")
    public void initUser(){
        for (int i =0; i < 10; i++){
            User user = new User("user" + i);
            userRepository.saveUser(user);
        }
    }
}
