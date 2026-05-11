package com.dharmik.securex_lite.service;


import com.dharmik.securex_lite.annotations.Secure;
import com.dharmik.securex_lite.model.UserContext;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
public class SecureInterceptor
        implements HandlerInterceptor {

    @Override
    public boolean preHandle(
            HttpServletRequest request,
            HttpServletResponse response,
            Object handler
    ) throws Exception {

        if (!(handler instanceof HandlerMethod method)) {
            return true;
        }

        Secure secure = method.getMethodAnnotation(Secure.class);

        if (secure == null) {
            return true;
        }

        UserContext user = ContextHolder.get();

        if (user == null) {
            response.setStatus(401);
            response.getWriter()
                    .write("Unauthorized");
            return false;
        }

        String requiredRole = secure.role();

        if (!requiredRole.isEmpty() &&
                !requiredRole.equals(user.getRole())) {
            response.setStatus(403);
            response.getWriter()
                    .write("Forbidden");
            return false;
        }
        return true;
    }
}
