package com.example.TicketsDemo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@Configuration
public class CustomAuthenticationSuccessHandler  implements AuthenticationSuccessHandler {
    @Override
    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,
                                        Authentication authentication) throws IOException, ServletException {
        httpServletRequest.getSession().setMaxInactiveInterval(60 * 60);
        String autoridades = authentication.getAuthorities().toString();
        if (autoridades.contains("ROL_S")) {
            httpServletResponse.sendRedirect("/index/tickets");
        } else if (autoridades.contains("ROL_T")) {
            httpServletResponse.sendRedirect("/index/tickets");
        } else if (autoridades.contains("ROL_C")) {
            httpServletResponse.sendRedirect("/index/pedirsoporte");
        } else {
            httpServletRequest.getSession(false).invalidate();
            httpServletResponse.sendRedirect("/auth/login");
        }

    }
}
