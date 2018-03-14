package com.zd.christopher.cipher;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import com.zd.christopher.converter.ByteConverter;

public class MD5CipherMaker
{
	private static MessageDigest messageDigest;
	private static final String CIPHER = "MD5";
	
	static
	{
		try
		{
			messageDigest = MessageDigest.getInstance(CIPHER);
		}
		catch (NoSuchAlgorithmException e)
		{
			e.printStackTrace();
		}
	}

	public static String cipher(String data)
	{
		if(data == null)
			return null;
		return cipher16(data);
	}

	public static String cipher16(String data)
	{
		if(data == null)
			return null;
		return ByteConverter.convertByteToHexString(cipherInByte(data)).substring(8, 24);
	}

	public static String cipher32(String data)
	{
		if(data == null)
			return null;
		return ByteConverter.convertByteToHexString(cipherInByte(data));
	}

	public static byte[] cipherInByte(String data)
	{
		if(data == null)
			return null;
		messageDigest.update(data.getBytes());
		return messageDigest.digest();
	}
}
