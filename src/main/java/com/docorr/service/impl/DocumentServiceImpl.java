package com.docorr.service.impl;

import com.docorr.dao.DocumentDao;
import com.docorr.model.entity.Document;
import com.docorr.service.DocumentService;
import io.leangen.graphql.annotations.GraphQLMutation;
import io.leangen.graphql.annotations.GraphQLQuery;
import io.leangen.graphql.spqr.spring.annotations.GraphQLApi;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author MW
 */
@Service
@GraphQLApi
public class DocumentServiceImpl implements DocumentService {

    @Autowired
    DocumentDao documentDao;

    public DocumentServiceImpl(DocumentDao documentDao) {
        this.documentDao = documentDao;
    }

    @GraphQLQuery(name = "documents")
    @Override
    public List<Document> getDocuments() {
        return documentDao.findAll();
    }

    @GraphQLQuery(name = "document")
    @Override
    public Document getDocumentById(Long id) {
        return documentDao.findById(id).orElse(null);
    }
    @GraphQLMutation(name = "saveDocument")
    @Override
    public Document saveDocument(Document document) {
        return documentDao.save(document);
    }

    @GraphQLMutation(name = "deleteDocument")
    @Override
    public void deleteDocument(Long id) {
        documentDao.deleteById(id);
    }

    @GraphQLQuery(name = "isGood")
    @Override
    public boolean isGood(Document document) {
        return !document.getTitle().equals("title1");
    }
}
