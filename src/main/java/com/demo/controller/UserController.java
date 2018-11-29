package com.demo.controller;

import com.demo.entity.User;
import com.demo.repository.Update;
import com.demo.repository.UserRepository;
import com.demo.service.UpdateSeviceImp;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by hanqiang.chen on 11/27/2018.
 */
@RestController
@RequestMapping("/users")
@Api(value = "用户管理", description = "用户管理")
public class UserController  extends BaseController {

    /**
     * 获取用户列表
     * @return
     */
    @ApiOperation(value = "查询用户列表")
    @GetMapping("/userList")
    public Map<String, Object> userList(){
        List<User> users = userRepository.findAll();
        logger.info("users: {}", users);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("users",users);
        return map;
    }

    @ApiOperation(value = "查询用户权限")
    @GetMapping("/authorityList")
    public List<String> authorityList(){
        List<String> authentication = getAuthentication();
        return authentication;
    }

    @ApiOperation(value = "更新用户信息")
    @PutMapping("/{id}")
    public User update(@PathVariable("id") String id,
                                         @RequestBody User user){
        Map<String, User> userHashMap = new HashMap<>();
        userHashMap.remove(id);
        user.setId(id);
        userHashMap.put(id, user);
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        return update.save(user);
    }

}
