package com.solvd.laba.sinder.web.controller;

import com.solvd.laba.sinder.domain.user.User;
import com.solvd.laba.sinder.service.UserService;
import com.solvd.laba.sinder.web.dto.UserDto;
import com.solvd.laba.sinder.web.dto.group.OnUpdate;
import com.solvd.laba.sinder.web.dto.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/users")
public class UserController {

    private final UserService userService;
    private final UserMapper userMapper;

    @PreAuthorize("@securityExpressions.isUser(#userId)")
    @GetMapping("/{userId}")
    public UserDto getById(@PathVariable Long userId) {
        User user = userService.retrieveById(userId);
        return userMapper.toDto(user);
    }

    @PreAuthorize("@securityExpressions.isUser(#userId)")
    @DeleteMapping("/{userId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long userId) {
        userService.delete(userId);
    }

    @PreAuthorize("@securityExpressions.isUser(#userId)")
    @PutMapping("/{userId}")
    public UserDto update(@Validated(OnUpdate.class) @RequestBody UserDto userDto,
                          @PathVariable Long userId) {
        User user = userMapper.toEntity(userDto);
        user.setId(userId);
        User updatedUser = userService.update(user);
        return userMapper.toDto(updatedUser);
    }

}
