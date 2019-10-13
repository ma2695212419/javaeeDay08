package cn.kgc.tangcco.tcbd1016.lihaozhe.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * Servlet Filter implementation class FilterLifecycle
 */
public class FilterLifecycle implements Filter {
	private int count;
    /**
     * Default constructor. 
     */
    public FilterLifecycle() {
        System.out.println("FilterLifecycle实例化");
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		System.out.println("轻轻的我走了");
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here

		// pass the request along the filter chain
		count++;
		System.out.println("我爱你 >>> " + count);
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		System.out.println("轻轻的我来了");
	}

}
