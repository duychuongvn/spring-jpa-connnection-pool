package vn.chuonghd.connectionpool.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import vn.chuonghd.connectionpool.domain.User;
import vn.chuonghd.connectionpool.repository.UserRepository;
import vn.chuonghd.connectionpool.service.UserService;

import java.util.List;

/**
 * Created by huynhduychuong on 4/2/2016.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User createUser(String name) {
        if (StringUtils.isEmpty(name)) {
            throw new NullPointerException("Name is null");
        }
        User user = new User();
        user.setName(name);
        return userRepository.saveAndFlush(user);
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }
}
