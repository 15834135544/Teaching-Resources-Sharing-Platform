package com.zd.christopher.dao;

import com.zd.christopher.bean.Video;

public interface IVideoDAO extends IEntityDAO<Video>, INaturalNameDAO<Video>
{
	public boolean updateCourse(Video video);
	public boolean updateUser(Video video);
	public boolean updateFavorUser(Video video);
}
