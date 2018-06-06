package com.spring.auth;

import com.spring.auth.token.Token;
import com.spring.pojo.Modules;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class LoginInInterceptor extends HandlerInterceptorAdapter {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        Token tokenUtil = new Token();
        String token = (String) request.getAttribute("token");
        List<Modules> userPermission = (List<Modules>) tokenUtil.uncreateToken(Modules.class , token);
        System.out.println(userPermission);
        return true;

    }
}
