package vn.chuonghd.connectionpool.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import vn.chuonghd.connectionpool.model.BaseResponse;
import vn.chuonghd.connectionpool.model.UserModel;

@Controller

public class HelloController {
    @RequestMapping(value = "/",method = RequestMethod.GET)
    public String printWelcome(ModelMap model) {
        model.addAttribute("message", "Hello world!");
        return "hello";
    }

    @RequestMapping(value = "/test", consumes = "application/json")
    @ResponseBody
    public BaseResponse<UserModel> home(@RequestBody UserModel userModel) {
        return new BaseResponse<UserModel>(userModel);

    }
}