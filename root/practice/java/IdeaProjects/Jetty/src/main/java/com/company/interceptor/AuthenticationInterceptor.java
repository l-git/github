package com.company.interceptor;

import com.company.annotation.SignInRequired;
import com.company.constant.SessionName;
import com.company.domain.User;
import org.apache.log4j.Logger;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpSession;
import java.lang.annotation.Annotation;

/**
 * Created by Galapagos on 2016/4/29.
 */
public class AuthenticationInterceptor extends HandlerInterceptorAdapter {

    private static final Logger logger =Logger.getLogger(AuthenticationInterceptor.class);

    @Override
    public boolean preHandle(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response, java.lang.Object handler)
            throws java.lang.Exception {
        logger.debug("preHandle");
        Class<?> handlerClass=handler.getClass();
        if(handlerClass.isAssignableFrom(HandlerMethod.class)) {
       /* String requestURI=request.getRequestURI();
        if(requestURI.equals("/")||requestURI.startsWith("/static")||requestURI.startsWith("/sign")){
            return true;
        }*/
        /*Class<?> handlerClass=handler.getClass();
        handlerClass.*/

            HandlerMethod handlerMethod= (HandlerMethod) handler;
            boolean annotationPresent=handlerMethod.getBeanType().isAnnotationPresent(SignInRequired.class);

           /* Annotation annotations[]=handlerMethod.getAnnotations();
            for(Annotation annotation:annotations){
                logger.debug(annotation);
            }*/
            /*boolean annotationPresent=handlerMethod.isAnnotationPresent(SignInRequired.class);*/
            if(annotationPresent) {
                logger.debug("annotationPresent true");
                HttpSession httpSession = request.getSession();

                User user = (User) httpSession.getAttribute(SessionName.USER);
                if (user == null) {
                    String scheme = request.getScheme();
                    String serverName = request.getServerName();
                    int port = request.getServerPort();
                    String url = scheme + "://" + serverName + ":" + port;
                    response.sendRedirect(url);
                    return false;
                }
            }else{
                logger.debug("annotationPresent false");
            }
        }else{
            logger.debug("handler.getClass().isAssignableFrom(SignInRequired.class) annotationPresent false");
        }


        return true;
    }

    @Override
    public void postHandle(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response, java.lang.Object handler, org.springframework.web.servlet.ModelAndView modelAndView) throws java.lang.Exception {
        logger.debug("postHandle");
    }

    @Override
    public void afterCompletion(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response, java.lang.Object handler, java.lang.Exception ex) throws java.lang.Exception {
        logger.debug("afterCompletion");
    }


}
