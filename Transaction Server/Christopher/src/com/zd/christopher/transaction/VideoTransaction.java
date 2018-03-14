package com.zd.christopher.transaction;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zd.christopher.bean.Video;
import com.zd.christopher.dao.IVideoDAO;

@Service
public class VideoTransaction extends BaseTransaction<Video> implements IVideoTransaction
{
	@Resource
	private IVideoDAO videoDAO;
	
	@PostConstruct
	public void init()
	{
		entityClass = Video.class;
	}

	public boolean updateFavorUser(Video video)
	{
		return false;
	}
	public List<Video> findByNaturalName(Video entity)
	{
		return videoDAO.findByNaturalName(entity.getVideoName());
	}

	public List<Video> findByNaturalNameByPage(Video entity, Integer count, Integer page)
	{	
		return videoDAO.findByNaturalNameByPage(entity.getVideoName(), count, page);
	}

	public List<Video> findByNaturalNames(Video[] entities)
	{
		List<String> nameList = new ArrayList<String>();
		for(Video video : entities)
			nameList.add(video.getVideoName());
		return videoDAO.findByNaturalNames((String[]) nameList.toArray());
	}
	
	public List<Video> findByNaturalNamesByPage(Video[] entities, Integer count, Integer page)
	{	
		List<String> nameList = new ArrayList<String>();
		for(Video video : entities)
			nameList.add(video.getVideoName());
		return videoDAO.findByNaturalNamesByPage((String[]) nameList.toArray(), count, page);
	}
}
