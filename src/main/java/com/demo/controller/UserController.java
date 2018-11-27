package com.demo.controller;

import com.demo.entity.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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
    @RequestMapping(value = "/userList", method = RequestMethod.GET)
    public Map<String, Object> userList(){
        List<User> users = userRepository.findAll();
        logger.info("users: {}", users);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("users",users);
        return map;
    }

    @ApiOperation(value = "查询用户权限")
    @RequestMapping(value = "/authorityList", method = RequestMethod.GET)
    public List<String> authorityList(){
        List<String> authentication = getAuthentication();
        return authentication;
    }

}
