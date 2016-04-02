package vn.chuonghd.connectionpool.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import vn.chuonghd.connectionpool.model.BaseResponse;
import vn.chuonghd.connectionpool.model.UserModel;
import vn.chuonghd.connectionpool.service.UserService;

import java.util.List;

/**
 * Created by huynhduychuong on 4/2/2016.
 */
@Controller
@RequestMapping("/user-manager")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/create", consumes = "application/json", method = RequestMethod.POST)
    @ResponseBody
    public BaseResponse<?> home(@RequestBody UserModel userModel) {
        return new BaseResponse(userService.createUser(userModel.getName()));

    }

    @RequestMapping(value = "/findAll", consumes = "application/json", method = RequestMethod.GET)
    @ResponseBody
    public BaseResponse<?> findAllUser() {
        return new BaseResponse(userService.findAll());

    }

}
