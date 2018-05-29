/*
package com.rest.practice.security;

import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(Ordered.HIGHEST_PRECEDENCE)
public class RequestFilter {
	
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) {
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) res;
		
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Access-control-Allow-Methods", "POST, PUT, GET, OPTIONS, DELETE");
		response.setHeader("Access-Control-Allow-Headers", "x-requested-with, x-auth-token");
		response.setHeader("Access-Control-Max-Age", "3600");
		response.setHeader("Access-Control-Allow-Credentials", "true");
		
		if(!(request.getMethod().equalsIgnoreCase("OPTIONS"))) {
			try {
				chain.doFilter(req, res);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("Pre-fight");
			response.setHeader("Access-Control-Allowed-Methods", "POST, GET, DELETE");
			response.setHeader("Access-Control-Max-Age", "3600");
			response.setHeader("Access-Control-Allow-Headers", "authorization, content-type, x-auth-token, " +
                    "access-control-request-headers,access-control-request-method,accept,origin,authorization,x-requested-with");
			response.setStatus(HttpServletResponse.SC_OK);
		}
	}
	
	public void init(FilterConfig filterConfig) {}
	
	public void destroy() {}
}

/*
Response Headers

Access-Control-Allow-Origin : specifies the authorized domains to make cross-domain request. 
Use “*” as value if there is no restrictions.

Access-Control-Allow-Credentials : specifies if cross-domain requests 
can have authorization credentials or not.

Access-Control-Expose-Headers : indicates which headers are safe to expose.

Access-Control-Max-Age : indicates how long the results of a preflight request can be cached.

Access-Control-Allow-Methods : indicates the methods allowed when accessing the resource.

Access-Control-Allow-Headers : indicates which header field names can be used during the 
actual request.


Request Headers
Origin : indicates where the cross-origin actual request or preflight request originates from.

Access-Control-Request-Method : used when issuing a preflight request to let the server know
 what HTTP method will be used in actual request.
 
Access-Control-Request-Headers : used when issuing a preflight request to let the server know what HTTP headers will be used in actual request.
*/