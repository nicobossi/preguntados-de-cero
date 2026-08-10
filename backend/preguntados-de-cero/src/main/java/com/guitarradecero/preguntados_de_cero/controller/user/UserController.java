package com.guitarradecero.preguntados_de_cero.controller.user;

import com.guitarradecero.preguntados_de_cero.adapter.user.UserMapper;
import com.guitarradecero.preguntados_de_cero.dto.user.UserResponseDto;
import com.guitarradecero.preguntados_de_cero.model.user.User;
import com.guitarradecero.preguntados_de_cero.security.user.UserDetailsImpl;
import com.guitarradecero.preguntados_de_cero.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
public class UserController {
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/me")
    public ResponseEntity<UserResponseDto> me(Authentication param) {
        UserDetailsImpl auth = (UserDetailsImpl) param.getPrincipal();
        User user = userService.getById(auth.getId());
        return ResponseEntity.ok(UserMapper.INSTANCE.modelToDto(user));
    }
}
