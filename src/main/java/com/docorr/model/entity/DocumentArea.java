package com.docorr.model.entity;

import io.leangen.graphql.annotations.GraphQLQuery;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author MW
 */
@Entity
@Table(name = "tb_document_area")
public class DocumentArea {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @GraphQLQuery(name = "id")
    private Long id;

    @Column(name = "create_date")
    @GraphQLQuery(name = "createDate")
    private LocalDateTime createDate;

//    @Column(name = "doc_id", insertable = false, updatable = false, nullable = false)
//    private Long docId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "doc_id", nullable = false)
    private Document document;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "documentArea")
    private List<DocumentAreaComment> documentAreaComments = new ArrayList<>();

    @ManyToOne(fetch = FetchType.LAZY)
    @GraphQLQuery(name = "user")
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

//    public Long getDocId() {
//        return docId;
//    }
//
//    public void setDocId(Long docId) {
//        this.docId = docId;
//    }

    public Document getDocument() {
        return document;
    }

    public void setDocument(Document document) {
        this.document = document;
    }

    public LocalDateTime getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDateTime createDate) {
        this.createDate = createDate;
    }

    public List<DocumentAreaComment> getDocumentAreaComments() {
        return documentAreaComments;
    }

    public void setDocumentAreaComments(List<DocumentAreaComment> documentAreaComments) {
        this.documentAreaComments = documentAreaComments;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

}
