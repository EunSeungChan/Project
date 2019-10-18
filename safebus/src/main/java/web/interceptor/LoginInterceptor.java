package web.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.ModelAndViewDefiningException;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import spring.biz.user.vo.UserVO;

public class LoginInterceptor extends HandlerInterceptorAdapter {
	
    @Override
    public boolean preHandle(HttpServletRequest request, 
    		               HttpServletResponse response, Object handler)
    		throws Exception {
    
    	UserVO vo = (UserVO) request.getSession().getAttribute("login");
    	
    	if(vo != null) {
    		return true;
    	}else {
    		ModelAndView mav = new ModelAndView("redirect:/login.do");
    		throw new ModelAndViewDefiningException(mav);
    	}
    	
    }
}
