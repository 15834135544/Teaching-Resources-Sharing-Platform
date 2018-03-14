package com.zd.christopher.validator;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.opensymphony.xwork2.validator.ValidationException;
import com.opensymphony.xwork2.validator.validators.FieldValidatorSupport;
import com.zd.christopher.bean.Document;
import com.zd.christopher.json.JsonForm;

public class DocumentActionValidator extends FieldValidatorSupport
{
	public void validate(Object object) throws ValidationException
	{
		String fieldName = this.getFieldName();
		Object fieldValue = this.getFieldValue(fieldName, object);
		
		if(fieldValue instanceof String)
			try
			{
				System.out.println("Action Validated!");
				new Gson().fromJson((String) fieldValue, new TypeToken<JsonForm<Document>>(){}.getType());
			}
			catch(Exception e)
			{
				addFieldError(fieldName, object);
			}
	}
}
