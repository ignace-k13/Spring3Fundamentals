package be.abis.exercise.aspect;

import org.aspectj.lang.annotation.Pointcut;

public class AopPointcuts {

	@Pointcut("execution( public * be.abis.exercise.service.*.enrol*(..)) ")
	public void execEnroll(){}

}
