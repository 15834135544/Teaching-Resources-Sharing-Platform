package com.zd.christopher.transaction;

import java.util.List;

import com.zd.christopher.bean.Document;

public class DocumentTransaction extends BaseTransaction<Document> implements IDocumentTransaction
{
	public DocumentTransaction()
	{
		entityClass = Document.class;
	}
	
	public boolean updateFavorUser(Document document)
	{
		return false;
	}
	
	public List<Document> findByNaturalName(Document entity)
	{
		return null;
	}

	public List<Document> findByNaturalNameByPage(Document entity, Integer count, Integer page)
	{	
		return null;
	}

	public List<Document> findByNaturalNames(Document[] entities)
	{
		return null;
	}
	
	public List<Document> findByNaturalNamesByPage(Document[] entities, Integer count, Integer page)
	{	
		return null;
	}
}
