package com.zd.christopher.validator;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.opensymphony.xwork2.validator.ValidationException;
import com.opensymphony.xwork2.validator.validators.FieldValidatorSupport;
import com.zd.christopher.bean.Administrator;
import com.zd.christopher.json.JsonForm;

public class AdministratorActionValidator extends FieldValidatorSupport
{
	public void validate(Object object) throws ValidationException
	{
		String fieldName = this.getFieldName();
		Object fieldValue = this.getFieldValue(fieldName, object);
		
		if(fieldValue instanceof String)
			try
			{
				System.out.println("Action Validated!");
				new Gson().fromJson((String) fieldValue, new TypeToken<JsonForm<Administrator>>(){}.getType());
			}
			catch(Exception e)
			{
				addFieldError(fieldName, object);
			}
	}
}
