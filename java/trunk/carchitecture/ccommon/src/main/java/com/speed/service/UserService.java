package com.speed.service;

import com.speed.exception.CommonException;
import com.speed.model.User;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

public interface UserService extends BaseService<Integer, User> {
    User login(String phone,String password) throws CommonException, UnsupportedEncodingException, NoSuchAlgorithmException;
}