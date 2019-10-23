package com.gaolei.config;

import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * 自定义表单登录
 */

public class CustomFromLoginFilter extends AbstractAuthenticationProcessingFilter {

    CustomFromLoginFilter(String defaultFilterProcessesUrl) {
        super(new AntPathRequestMatcher(defaultFilterProcessesUrl, HttpMethod.POST.name()));
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws AuthenticationException, IOException, ServletException {
        String username = httpServletRequest.getParameter("username");
        String password = httpServletRequest.getParameter("password");
        customCheck(username, password);
        List<SimpleGrantedAuthority> simpleGrantedAuthorities = new ArrayList<>();
        simpleGrantedAuthorities.add(new SimpleGrantedAuthority("USER"));
        return new UsernamePasswordAuthenticationToken(username, password, simpleGrantedAuthorities);
    }
    /**
     * UsernamePasswordAuthenticationToken
     *继承AbstractAuthenticationToken实现Authentication
     *         所以当在页面中输入用户名和密码之后首先会进入到UsernamePasswordAuthenticationToken验证(Authentication)，
     *         然后生成的Authentication会被交由AuthenticationManager来进行管理
     *         而AuthenticationManager管理一系列的AuthenticationProvider，
     *         而每一个Provider都会通UserDetailsService和UserDetail来返回一个
     *         以UsernamePasswordAuthenticationToken实现的带用户名和密码以及权限的Authentication
     * */



    /**
     * 自定义登录校验逻辑
     * */
    private void customCheck(String username, String password){
        if (!("admin".equals(username) && "123".equals(password))){
            throw new RuntimeException("用户名或密码错误！");
        }

    }

}
