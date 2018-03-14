package com.zd.christopher.bean;

import java.io.Serializable;

public abstract class Entity implements Serializable, Cloneable
{
	private static final long serialVersionUID = 1L;
	protected static final String ENTITY_PATH = "/data//data/com.zd.christopher/entity/";
	
	public abstract String findPath();
	
}
