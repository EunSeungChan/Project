package aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class TimeCheckAdvice {
	private static final Logger LOGGER = LoggerFactory.getLogger("root");

	public void userPointcut() {
	}

	@Around("execution(* spring.biz.user.service.UserService.login(..))")
	public Object aroundLog(ProceedingJoinPoint pjp) throws Throwable {
		Object obj = null;
		String method = pjp.getSignature().getName();
		long start = System.currentTimeMillis();

		obj = pjp.proceed();

		long end = System.currentTimeMillis();
		System.out.println(method + "() 메소드 수행에 걸린 시간 : " + (end - start) + "ms(초)");
		LOGGER.info(method + "() 메소드 수행에 걸린 시간 : " + (end - start) + "ms(초)");
		return obj;
	}

	@AfterThrowing(pointcut = "execution(* spring.biz.user.service.UserService.login(..))", throwing = "e")
	public void ex(JoinPoint jp, Exception e) {
		System.out.println("**************** 예외 발생 *********************");
		System.out.println(e.getMessage());
		LOGGER.error("AOP : " + jp.getSignature().getName() + " : ", e.getMessage());
		System.out.println("********************************************");
	}
}
