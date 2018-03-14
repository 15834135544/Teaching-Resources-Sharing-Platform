package com.zd.christopher.dao;

import com.zd.christopher.bean.Document;

public interface IDocumentDAO extends IEntityDAO<Document>, INaturalNameDAO<Document>
{
	public boolean updateCourse(Document document);
	public boolean updateAuthor(Document document);
	public boolean updateFavorUser(Document document);
}
