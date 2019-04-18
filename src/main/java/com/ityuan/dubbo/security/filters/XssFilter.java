package com.ityuan.dubbo.security.filters;


import com.ityuan.dubbo.security.utils.XssHttpServletRequestWrapper;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * XSS 攻击防御过滤器
 * @author ityuan
 * @version XssFilter, v 0.1  2019/4/18 15:14
 */
@WebFilter(filterName="xssFilter",urlPatterns="/*")
public class XssFilter implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		XssHttpServletRequestWrapper requestWrapper = new XssHttpServletRequestWrapper((HttpServletRequest) request);
		String name =requestWrapper.getParameter("name");
		chain.doFilter(requestWrapper, response);
	}


}
