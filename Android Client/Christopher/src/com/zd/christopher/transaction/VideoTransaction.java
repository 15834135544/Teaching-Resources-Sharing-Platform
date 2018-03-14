package com.zd.christopher.transaction;

import java.util.List;

import com.zd.christopher.bean.Video;

public class VideoTransaction extends BaseTransaction<Video> implements IVideoTransaction
{
	public VideoTransaction()
	{
		entityClass = Video.class;
	}

	public boolean updateFavorUser(Video video)
	{
		return false;
	}
	public List<Video> findByNaturalName(Video entity)
	{
		return null;
	}

	public List<Video> findByNaturalNameByPage(Video entity, Integer count, Integer page)
	{	
		return null;
	}

	public List<Video> findByNaturalNames(Video[] entities)
	{
		return null;
	}
	
	public List<Video> findByNaturalNamesByPage(Video[] entities, Integer count, Integer page)
	{	
		return null;
	}
}
