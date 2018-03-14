package com.zd.christopher.converter;

import com.zd.christopher.enumeration.Result;

public class ByteConverter
{
	public static String convertByteToHexString(byte[] bytes)
	{
		if(bytes == null)
			return Result.FAILURE.getString();
		StringBuffer stringBuffer = new StringBuffer();
		for (byte aByte : bytes)
		{
			String data = Integer.toHexString(0xff & aByte);
	        if(data.length() == 1)
	        	stringBuffer.append("0" + data);
	        else
	        	stringBuffer.append(data);  
		}
		return stringBuffer.toString();
	}
	
}
