package com.demo.controller;

import com.demo.constant.ConstantKey;
import com.demo.entity.User;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by hanqiang.chen on 11/27/2018.
 */
@RestController
@Api(value = "登录管理", description = "登录管理")
public class LoginController  extends BaseController {

    @ApiOperation(value = "自定义登录")
    @RequestMapping(value = "/login", method = {RequestMethod.POST})
    public void login(String username, String password, HttpServletResponse response) {
        User userVo = userRepository.findByUsername(username);
        if (userVo != null) {
            /**
             * 自定义生成Token，因为使用了自定义登录，就不会执行JWTLoginFilter了，所以需要字段调用生成token并返给前端
             */
            // 根据用户信息查询对应的角色信息
            List roleList = new ArrayList<>();
            String subject = userVo.getUsername() + "-" + roleList;
            String token = Jwts.builder()
                    .setSubject(subject)
                    .setExpiration(new Date(System.currentTimeMillis() + 365 * 24 * 60 * 60 * 1000)) // 设置过期时间 365 * 24 * 60 * 60秒
                    .signWith(SignatureAlgorithm.HS512, ConstantKey.SIGNING_KEY)
                    .compact();
            // 登录成功后，返回token到header里面
            response.addHeader("Authorization", "Bearer " + token);
        }
    }
}
