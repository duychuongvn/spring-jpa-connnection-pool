package vn.chuonghd.connectionpool.service;

import vn.chuonghd.connectionpool.domain.User;

import java.util.List;

/**
 * Created by huynhduychuong on 4/2/2016.
 */
public interface UserService {

    User createUser(String name);
    List<User> findAll();
}
