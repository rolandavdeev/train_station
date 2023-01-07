package jwtrestapp.rest;

import jwtrestapp.JwtAppDemoApplication;
import jwtrestapp.dto.UserDto;
import jwtrestapp.model.User;
import jwtrestapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@CrossOrigin(origins = JwtAppDemoApplication.ALLOWED_HOST,allowCredentials = "true")
@RestController
@RequestMapping(value = "/api/users/")
public class UserRestController {
    private final UserService userService;

    @Lazy
    @Autowired
    public UserRestController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "{id}")
    public ResponseEntity<UserDto> getUserById(@PathVariable(name = "id") Long id){
        User user = userService.findById(id);

        if(user == null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        UserDto result = UserDto.fromUser(user);

        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
