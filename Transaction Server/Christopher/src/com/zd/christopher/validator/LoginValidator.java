package com.zd.christopher.validator;

import java.util.Set;

import javax.validation.ConstraintViolation;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.zd.christopher.bean.User;

@Aspect
@Component
@Order(1)
public class LoginValidator extends BaseValidator
{
	public interface ILoginValidator
	{
		
	}
	
	@SuppressWarnings("unused")
	@Pointcut("execution(public boolean com.zd.christopher.transaction.UserTransaction.login(..))")
    private void loginValidation()
    {
    	
    }
    
    @Before("loginValidation() && args(user)")
    public void validate(User user)
    {
    	System.out.println("LoginValidator AOP");
    	//If User.user is null, an IllegalArgumentException will be thrown out.
		Set<ConstraintViolation<User>> errorSet = validator.validate(user, ILoginValidator.class);
		if(!errorSet.isEmpty())
		{
			//DEBUG
			for(ConstraintViolation<User> c : errorSet)
				System.out.println(c.getMessage());
		 	throw new IllegalArgumentException();
		}
    }
}
