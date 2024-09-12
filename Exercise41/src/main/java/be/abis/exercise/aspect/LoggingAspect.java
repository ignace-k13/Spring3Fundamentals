package be.abis.exercise.aspect;

import be.abis.exercise.exception.EnrollException;
import be.abis.exercise.model.Person;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {

	@AfterReturning("AopPointcuts.execEnroll()")
	public void logPersonEnrolled(JoinPoint jp){
		String firstName = ((Person)jp.getArgs()[0]).getFirstName();
		System.out.println("logging enrollment: " + firstName + "'s enrollment was processed ok");
	}
	
	@AfterThrowing(pointcut="AopPointcuts.execEnroll()",throwing="exc")
	public void logProblemEnrolling(EnrollException exc){
		System.out.println("logging exception: "+ exc.getMessage());
	}

}
