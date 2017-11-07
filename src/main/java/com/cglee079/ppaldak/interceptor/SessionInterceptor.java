package com.cglee079.ppaldak.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/*Interceptor Class*/
public class SessionInterceptor extends HandlerInterceptorAdapter {
	Log logger = LogFactory.getLog("SESSION CHECK");

	/* Controller 호출 전 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		System.out.println("ddd");
		/* Controller 호출 전 세션 체크, 세션이 없을 경우 로그인 페이지로 이동 */
		boolean result = true;
		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("id");

		if (id == null) {
			logger.info("RESULT  : FALSE -----> REDIRECT LOGIN PAGE");
			response.sendRedirect(request.getContextPath() + "/"); // 이동
			result = false; // return false; 컨트롤러 호출을 더이상 진행 하지 않음;
		} else {
			logger.info("RESULT  : TRUE");
		}

		return result;
	}

	/* Controller 호출 후 */
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		super.postHandle(request, response, handler, modelAndView);

	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		super.afterCompletion(request, response, handler, ex);
	}

	@Override
	public void afterConcurrentHandlingStarted(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		super.afterConcurrentHandlingStarted(request, response, handler);
	}
}
