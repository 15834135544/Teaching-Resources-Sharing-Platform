package com.zd.christopher.transaction;

import com.zd.christopher.bean.Video;

public interface IVideoTransaction extends INaturalNameTransaction<Video>
{
	public boolean updateFavorUser(Video video);
}
