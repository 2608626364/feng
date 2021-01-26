package com.fengfan.config;

import com.fengfan.user.pojo.UserDetail;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;

import javax.annotation.Resource;
import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: fengfan
 * @Date: 2020/11/17 20:26
 */
@Log4j2
@WebFilter(filterName = "loginFiler", urlPatterns = "/*")
public class LoginFilter implements Filter {

    @Resource
    RedisTemplate redisTemplate;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        log.info("LoginFilter初始化。。。。。");
    }


    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        log.info("Filter过滤之前");
        HttpServletRequest req = (HttpServletRequest) request;
        BufferedReader reader = req.getReader();
       /* Map<String,Object> params = new HashMap<String, Object>();
        BufferedReader br;
        try {
            br = request.getReader();
            String str, wholeStr = "";
            while((str = br.readLine()) != null){
                wholeStr += str;
            }
            log.info(wholeStr);
            if(!StringUtils.isEmpty(wholeStr)){
                params = JSON.parseObject(wholeStr,Map.class);
            }
        } catch (IOException e1) {
            log.error(""+e1);
        }*/
        log.info(reader);
        String uri = req.getRequestURI();
        String userId = request.getParameter("user_id");
        log.info(uri);
        if (uri.indexOf("/login") != -1) {
            UserDetail user = (UserDetail) redisTemplate.opsForValue().get(userId);
            log.info(user);
        }
        chain.doFilter(request, response);
        log.info("Filter过滤之后");
    }


    @Override
    public void destroy() {
        log.info("Filter销毁");
    }
}
