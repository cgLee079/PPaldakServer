package com.cglee079.ppaldak.intercepter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.cglee079.ppaldak.log.Log;

/*Interceptor Class*/
public class SessionIntercepter extends HandlerInterceptorAdapter {
	/* Controller 호출 전 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		
		Log.line();
		Log.line();
		Log.i("## Session check");
		
		/* Controller 호출 전 세션 체크, 세션이 없을 경우 로그인 페이지로 이동 */
		boolean result = true;
		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("id");

		if (id == null) {
			Log.i("# session  : false, redirect");
			response.sendRedirect(request.getContextPath() + "/error"); // 이동
			result = false; // return false; 컨트롤러 호출을 더이상 진행 하지 않음;
		} else {
			Log.i("# session  : true");
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
