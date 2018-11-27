package com.demo.service;

import org.springframework.security.core.GrantedAuthority;

/**
 * Created by hanqiang.chen on 11/27/2018.
 */
public class GrantedAuthorityImpl implements GrantedAuthority{
    private String authority;

    public GrantedAuthorityImpl(String authority) {
        this.authority = authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }

    @Override
    public String getAuthority() {
        return this.authority;
    }
}
