package com.zd.christopher.reflector;

import java.lang.reflect.Field;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

import org.hibernate.collection.PersistentSet;
import org.objectweb.asm.xwork.commons.Method;

public class Reflector
{
	public static <T> void mergePOJOs(T origin, T destination)
	{
		if (origin == null || destination == null)
			return;
		Field[] fields = origin.getClass().getDeclaredFields();
		for (int i = 0; i < fields.length; i++) 
		{
			try 
			{
				fields[i].setAccessible(true);
				Object value = fields[i].get(origin);
				if (null != value && !(value instanceof Collection<?>))	//Collections are exempt from merging.
				{
					fields[i].set(destination, value);
				}
				fields[i].setAccessible(false);
			}
			catch (IllegalAccessException e)
			{
				//suppress exception if a static final field is being merged.
			}
		}
	}
	
	public static Object getFieldValue(Object object, String fieldKey)
	{
		if(object == null || fieldKey == null)
			return null;
		Object fieldValue = null;
		try
		{
			Field field = object.getClass().getDeclaredField(fieldKey);
			field.setAccessible(true);
			fieldValue = field.get(object);
			field.setAccessible(false);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return fieldValue;
	}
	
	public static <T> void replaceCollection(T origin, T destination, String CollectionFieldKey)
	{
		if (origin == null || destination == null || CollectionFieldKey == null)
			return;
		try
		{
			Field field = destination.getClass().getDeclaredField(CollectionFieldKey);
			field.setAccessible(true);
			Object fieldValue = field.get(origin);
			if(fieldValue instanceof  Collection<?>)
				field.set(destination, fieldValue);
			field.setAccessible(false);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	
	public static boolean changeFieldValue(Object object, String fieldKey, Object value)
	{
		if(object == null || fieldKey == null)
			return false;
		try
		{
			Field field = object.getClass().getDeclaredField(fieldKey);
			field.setAccessible(true);
			field.set(object, value);
			field.setAccessible(false);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return true;
	}
	
	public static void depressCircularReferenceInCollcetion(Object object)
	{
			Field[] fields = object.getClass().getDeclaredFields();
			for(Field field : fields)
			{
				Object fieldObject = null;
				try
				{
					field.setAccessible(true);
					fieldObject = field.get(object);
				}
				catch(Exception e)
				{
					
				}
				if(fieldObject instanceof Set<?>)
				{
					System.out.println(fieldObject.getClass());
					Iterator<?> iterator = ((Set<?>) fieldObject).iterator();
					while(iterator.hasNext())
					{
						Object collectionObject = iterator.next();
						Field[] refFields = collectionObject.getClass().getDeclaredFields();
						for(Field refField : refFields)
						{
							Object refFieldObject = null;
							try
							{
								refField.setAccessible(true);
								refFieldObject = refField.get(collectionObject);
							}
							catch(Exception e)
							{
								
							}
							if(refFieldObject instanceof Collection<?>)
							{
								try
								{
									refField.setAccessible(true);
									refField.set(refFieldObject, null);
									refField.setAccessible(false);
								}
								catch(Exception e)
								{
									
								}
							}
						}
					}
				}
		}
	}
	
}
