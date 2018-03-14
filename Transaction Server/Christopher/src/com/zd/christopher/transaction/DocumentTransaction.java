package com.zd.christopher.transaction;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zd.christopher.bean.Document;
import com.zd.christopher.dao.IDocumentDAO;
@Service
public class DocumentTransaction extends BaseTransaction<Document> implements IDocumentTransaction
{
	@Resource
	private IDocumentDAO documentDAO;
	
	@PostConstruct
	public void init()
	{
		entityClass = Document.class;
	}
	
	public boolean updateFavorUser(Document document)
	{
		return false;
	}
	
	public List<Document> findByNaturalName(Document entity)
	{
		return documentDAO.findByNaturalName(entity.getDocumentName());
	}

	public List<Document> findByNaturalNameByPage(Document entity, Integer count, Integer page)
	{	
		return documentDAO.findByNaturalNameByPage(entity.getDocumentName(), count, page);
	}

	public List<Document> findByNaturalNames(Document[] entities)
	{
		List<String> nameList = new ArrayList<String>();
		for(Document document : entities)
			nameList.add(document.getDocumentName());
		return documentDAO.findByNaturalNames((String[]) nameList.toArray());
	}
	
	public List<Document> findByNaturalNamesByPage(Document[] entities, Integer count, Integer page)
	{	
		List<String> nameList = new ArrayList<String>();
		for(Document document : entities)
			nameList.add(document.getDocumentName());
		return documentDAO.findByNaturalNamesByPage((String[]) nameList.toArray(), count, page);
	}
}
