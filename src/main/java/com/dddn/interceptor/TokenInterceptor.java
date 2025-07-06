package com.dddn.interceptor;

import com.dddn.utils.CurrentLocal;
import com.dddn.utils.JwtUtils;
import io.jsonwebtoken.Claims;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
public class TokenInterceptor implements HandlerInterceptor {
    private static final Logger log = LoggerFactory.getLogger(TokenInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String token = request.getHeader("token");
        if(token == null || token.isEmpty()){
            log.info("token为空 请求失败");
            response.setStatus(401);
            return false;
        }
        try {
            Claims claims = JwtUtils.parseJwt(token);
            Integer empId = (Integer) claims.get("id");
            CurrentLocal.setThreadLocal(empId);
            log.info("token验证通过 请求成功");
        } catch (Exception e) {
            e.printStackTrace();
            log.info("token失效 请求失败");
            response.setStatus(401);
            return false;
        }
        return true;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        CurrentLocal.remove();
    }
}
