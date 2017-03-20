package com.jungang.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

@Component
@Aspect
@Order(Ordered.LOWEST_PRECEDENCE)
public class LoggingAspect {

	@Around("execution(* com.jungang..*.*(..)) "
	  + "&& !execution(* com.jungang.interceptor.*.*(..)) "
	  + "&& !execution(* com.jungang.aop.*.*(..))"
	)
	public Object logMethod(ProceedingJoinPoint joinPoint) throws Throwable {
		final Logger logger = LoggerFactory.getLogger(joinPoint.getTarget().getClass());
		Object retVal = null;
		
		try {
			StringBuffer startMsgSB = new StringBuffer();
			
			startMsgSB.append("[Start method] ");
			startMsgSB.append(joinPoint.getSignature().getName());
			startMsgSB.append("(");
			
			Object[] args = joinPoint.getArgs();
			for(int i=0; i<args.length; i++) {
				startMsgSB.append(args[i]).append(",");
			}
			
			if(args.length > 0)
			startMsgSB.deleteCharAt(startMsgSB.length() - 1);
			startMsgSB.append(")");
			
			logger.info(startMsgSB.toString());
			StopWatch stopWatch = new StopWatch();
			stopWatch.start();
			
			retVal = joinPoint.proceed();
			
			stopWatch.stop();
			StringBuffer endMsgSB = new StringBuffer();
			endMsgSB.append("[Finish method] ");
			endMsgSB.append(joinPoint.getSignature().getName());
			endMsgSB.append("(..); execution time: ");
			endMsgSB.append(stopWatch.getTotalTimeMillis());
			endMsgSB.append(" ms;");
			
			logger.info(endMsgSB.toString());
		}
		catch(Throwable e) {
			StringBuffer errMsgSB = new StringBuffer();
			logger.error(errMsgSB.toString(), e);
			throw e;
		}
		
		return retVal;
	}
}
