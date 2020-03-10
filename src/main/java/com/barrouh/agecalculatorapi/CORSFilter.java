package com.barrouh.agecalculatorapi;

import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.*;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CORSFilter extends GenericFilterBean implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        HttpServletResponse httpResponse = (HttpServletResponse) response;
        httpResponse.setHeader("Access-Control-Allow-Origin", "localhost");
        httpResponse.setHeader("Access-Control-Allow-Methods", "POST, GET");
        httpResponse.setHeader("Access-Control-Allow-Headers","Origin, X-Requested-With, Content-Type, Accept, X-Auth-Token, X-Csrf-Token, WWW-Authenticate, Authorization");
        httpResponse.setHeader("Access-Control-Expose-Headers", "custom-token1, custom-token2");
        httpResponse.setHeader("Access-Control-Allow-Credentials", "false");
        httpResponse.setHeader("Content-Type", "application/json");
        httpResponse.setHeader("Access-Control-Max-Age", "3600");

        logger.debug("********** CORS Configuration Completed **********");
        chain.doFilter(request, response);
    }

}