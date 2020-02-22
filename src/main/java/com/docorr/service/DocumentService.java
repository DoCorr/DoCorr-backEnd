package com.docorr.service;

import com.docorr.model.entity.Document;
import io.leangen.graphql.annotations.GraphQLContext;
import java.util.List;

/**
 *
 * @author MW
 */
public interface DocumentService {

    public List<Document> getDocuments();

    public Document getDocumentById(Long id);

    public Document saveDocument(Document document);

    public void deleteDocument(Long id);

    public boolean isGood(@GraphQLContext Document document);
}
