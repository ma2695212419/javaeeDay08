package cn.kgc.tangcco.tcbd1016.lihaozhe.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;

/**
 * Servlet Filter implementation class FilterLifecycle
 */
@WebFilter(filterName = "filterIsLogin", urlPatterns = "*.action")
public class FilterIsLogin implements Filter {

	/**
	 * Default constructor.
	 */
	public FilterIsLogin() {
		System.out.println("我是过滤器的无参构造方法");
	}

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		String queryString = req.getQueryString();
		System.out.println("queryString >>> " + queryString);
		if (!StringUtils.isEmpty(queryString)) {
			if (!queryString.contains("methodName")) {
				mehtodNameCheck(req, resp);
				return;
			}
		} else {
			mehtodNameCheck(req, resp);
			return;
		}
		// 放行
		chain.doFilter(request, response);
	}

	private void mehtodNameCheck(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		// 会话失效
		req.getSession().invalidate();
		resp.sendRedirect(req.getContextPath() + "/login.jsp");
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
	}

}
