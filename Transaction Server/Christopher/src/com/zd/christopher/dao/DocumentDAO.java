package com.zd.christopher.dao;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Repository;

import com.zd.christopher.bean.Document;
@Repository
public class DocumentDAO extends EntityDAO<Document> implements IDocumentDAO
{
	@PostConstruct
	public void init()
	{
		entityClass = Document.class;
	}
	public List<Document> findByNaturalName(String name)
	{
		return null;
	}

	public List<Document> findByNaturalNameByPage(String name, Integer count, Integer page)
	{
		return null;
	}

	public List<Document> findByNaturalNames(String[] name)
	{
		return null;
	}

	public List<Document> findByNaturalNamesByPage(String[] name, Integer count, Integer page)
	{
		return null;
	}

	public boolean updateCourse(Document document)
	{
		return true;
	}

	public boolean updateAuthor(Document document)
	{	
		return false;
	}

	public boolean updateFavorUser(Document document)
	{
		return false;
	}

}
