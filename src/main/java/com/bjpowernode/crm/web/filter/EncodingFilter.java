package com.bjpowernode.crm.web.filter;


import javax.servlet.*;
import java.io.IOException;

public  class EncodingFilter implements Filter {


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=utf-8");
        filterChain.doFilter(request, response);
    }

    @Override
    public void destroy() {

    }


}
