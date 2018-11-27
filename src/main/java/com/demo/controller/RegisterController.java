package com.demo.controller;

import com.demo.entity.User;
import com.demo.exception.UsernameIsExitedException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by hanqiang.chen on 11/27/2018.
 */
@RestController
@RequestMapping("/users")
@Api(value = "注册管理", description = "注册管理")
public class RegisterController extends BaseController {

    /**
     * 注册用户 默认开启白名单
     * @param user
     */
    @ApiOperation(value = "注册用户")
    @RequestMapping(value = "/signup", method = RequestMethod.POST)
    public User signup(@RequestBody User user) {
        User bizUser = userRepository.findByUsername(user.getUsername());
        //User bizuser = userRepository.findByUsername(user.getEmail());
        if(null != bizUser){
            if (userRepository.findByEmail(user.getEmail()) != null){
                throw new UsernameIsExitedException("用户已经存在,用户邮箱已经存在");
            }else {
                throw new UsernameIsExitedException("用户已经存在");
            }
        }
        if (userRepository.findByEmail(user.getEmail()) != null){
            throw new UsernameIsExitedException("用户邮箱已经存在");
        }
        //user.setPassword(DigestUtils.md5DigestAsHex((user.getPassword()).getBytes()));
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

}
