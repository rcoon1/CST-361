package util;

import java.io.Serializable;

import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;
import javax.transaction.Transactional;

@Interceptor
@Transactional
public class LoggingInterceptor implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@AroundInvoke 
	public Object methodInterceptor(InvocationContext ctx) throws Exception 
	{ 
	System.out.println("******************* Intercepting call to method: " +  
	ctx.getTarget().getClass() + "." + ctx.getMethod().getName() + "()"); 
	return ctx.proceed(); 
	} 

}