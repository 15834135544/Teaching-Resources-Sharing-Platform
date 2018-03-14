package com.zd.christopher.transaction;

import com.zd.christopher.bean.Document;

public interface IDocumentTransaction extends INaturalNameTransaction<Document>
{
	public boolean updateFavorUser(Document document);
}
