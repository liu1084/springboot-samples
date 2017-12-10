package com.jim.interceptor.model.interceptor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Enumeration;

/**
 * @author: liu jun
 * @date: 19:35 2017/12/9
 * @ver: 1.0
 * @desc:
 */
@Component
public class MyInterceptor implements HandlerInterceptor {

	private static final Logger LOGGER = LoggerFactory.getLogger(MyInterceptor.class);

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

		return true;
	}


//	private void logPost(HttpServletRequest request) throws IOException {
//		WrappedRequest wrappedRequest = new WrappedRequest(request);
//		;
//		ServletInputStream inputStream = null;
//		try {
//			inputStream = wrappedRequest.getInputStream();
//			String result = new BufferedReader(new InputStreamReader(inputStream)).lines().collect(Collectors.joining("\n"));
//			LOGGER.debug(result);
//			inputStream.close();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//	}
	private void logGet(HttpServletRequest request){
		Enumeration<String> requestParams = request.getParameterNames();
		while (requestParams.hasMoreElements()){
			String element = requestParams.nextElement();
			LOGGER.debug(request.getParameter(element));
		}
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

	}
}
