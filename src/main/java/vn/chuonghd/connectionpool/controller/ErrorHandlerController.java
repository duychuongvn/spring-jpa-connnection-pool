package vn.chuonghd.connectionpool.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import vn.chuonghd.connectionpool.model.BaseResponse;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by huynhduychuong on 4/2/2016.
 */
@ControllerAdvice
public class ErrorHandlerController {

    @ExceptionHandler()
    @ResponseBody
    public BaseResponse handleException(HttpServletRequest httpServletRequest, HttpServletResponse response, Exception ex) {

        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setStatus("0");
        baseResponse.setMessageCode("500");
        baseResponse.setMessageInfo("Unknown error");
        return baseResponse;
    }
}
