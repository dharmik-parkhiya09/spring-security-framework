package com.dharmik.securex_lite.service;


import com.dharmik.securex_lite.model.UserContext;

public class ContextHolder {

    private static final ThreadLocal<UserContext>
            context = new ThreadLocal<>();

    public static void set(UserContext user) {
        context.set(user);
    }

    public static UserContext get() {
        return context.get();
    }

    public static void clear() {
        context.remove();
    }
}
