package com.spring.auth;
import com.spring.auth.Exception.NOLoginException;
import com.spring.auth.Exception.NoPermissionException;
import com.spring.auth.token.JSON_WEB_TOKEN;
import com.spring.auth.token.Token;
import com.spring.pojo.Modules;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
import java.util.List;

public class LoginInInterceptor extends HandlerInterceptorAdapter {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)throws NOLoginException,NoPermissionException{

        String url = request.getServletPath();
        if(url.matches(SystemUtil.STATIC_NO_PERMISSION_PATH)){
            return true;
        }
        String token=request.getParameter("token");
        //前端没传token
        if(token==null){
            return true;
        }

        JSON_WEB_TOKEN tokens=null;
        try {
            tokens = new Token().uncreateToken(JSON_WEB_TOKEN.class,token);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        System.out.println(tokens.toString());
        List<String> userPermission=tokens.getPermissions();
        if(userPermission==null){
            throw new NOLoginException("请先登陆");
        }
        if(handler instanceof HandlerMethod){
            String permissionURL = SystemUtil.getMethodOfPermission((HandlerMethod) handler);
            if(!userPermission.contains(permissionURL)){
                throw new NoPermissionException("你没有访问该资源的权限,请联系我！！！");
            }
        }
        return true;
    }
}
