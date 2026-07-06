package com.dharmik.securex_lite.service;


import com.dharmik.securex_lite.annotations.CurrentUser;
import com.dharmik.securex_lite.model.UserContext;
import org.springframework.core.MethodParameter;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.*;
import org.springframework.web.method.support.ModelAndViewContainer;
@Component
public class CurrentUserResolver implements HandlerMethodArgumentResolver {

    @Override
    public boolean supportsParameter(
            MethodParameter parameter
    ) {

        return parameter.hasParameterAnnotation(
                CurrentUser.class
        ) && parameter.getParameterType()
                .equals(UserContext.class);
    }

    public Object resolveArgument(
            MethodParameter parameter,
            ModelAndViewContainer mavContainer,
            NativeWebRequest webRequest,
            WebDataBinderFactory binderFactory
    ) {

        return ContextHolder.get();
    }


}
