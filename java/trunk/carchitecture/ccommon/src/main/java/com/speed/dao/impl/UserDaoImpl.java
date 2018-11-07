package com.speed.dao.impl;

import com.speed.dao.UserDao;
import com.speed.model.User;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl extends BaseDaoImpl<Integer, User> implements UserDao {

}