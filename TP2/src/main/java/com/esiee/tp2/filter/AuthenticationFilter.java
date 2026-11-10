package com.esiee.tp2.filter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

// 拦截所有访问 /protected/ 下的请求
@WebFilter("/protected/*")
public class AuthenticationFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // 初始化方法（可留空）
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;

        // 获取当前 session，如果不存在则不自动创建（false）
        HttpSession session = httpRequest.getSession(false);

        // 检查 session 中是否存在 login 属性
        boolean isLoggedIn = (session != null && session.getAttribute("login") != null);

        if (isLoggedIn) {
            // 已登录：允许继续访问目标资源
            chain.doFilter(request, response);
        } else {
            // 未登录：重定向到未授权提示页面 not_authorized.jsp
            // contextPath 可以确保路径从根目录开始计算
            httpResponse.sendRedirect(httpRequest.getContextPath() + "/not_authorized.jsp");
        }
    }

    @Override
    public void destroy() {
        // 销毁方法（可留空）
    }
}
