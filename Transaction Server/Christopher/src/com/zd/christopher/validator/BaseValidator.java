package com.zd.christopher.validator;

import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

public abstract class BaseValidator
{
	protected final static ValidatorFactory validatorFactory;
	protected final static Validator validator;
	
	static
	{
		validatorFactory = Validation.buildDefaultValidatorFactory();
		validator = validatorFactory.getValidator();
	}
}
