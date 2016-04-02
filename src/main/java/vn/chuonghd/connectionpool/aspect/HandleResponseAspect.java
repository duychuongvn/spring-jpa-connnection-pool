package vn.chuonghd.connectionpool.aspect;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.util.List;
import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.util.ReflectionUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.util.WebUtils;
import vn.chuonghd.connectionpool.exception.XSSException;
import vn.chuonghd.connectionpool.model.BaseResponse;

/**
 * Created by huynhduychuong on 4/1/2016.
 */
public class HandleResponseAspect {

    private static final Logger log = LoggerFactory.getLogger(HandleResponseAspect.class);
    @Autowired
    private HttpServletRequest httpRequest;

    public Object handleResponseStatus(ProceedingJoinPoint joinPoint)
            throws Throwable {
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        log.info("Start request:" + httpRequest.getRequestURI());
        Object[] methodArguments = joinPoint.getArgs();
        Annotation[][] annotations = methodSignature.getMethod().getParameterAnnotations();

        Object result = joinPoint.proceed();
        if (result instanceof BaseResponse) {
            BaseResponse baseResponse = (BaseResponse) result;
            log.info("Response status: {} ", baseResponse.getMessageInfo());
        }
        log.info("End request:" + httpRequest.getRequestURI());
        return result;
    }
}
