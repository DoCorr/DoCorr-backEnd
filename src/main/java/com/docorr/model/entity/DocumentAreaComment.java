package com.docorr.model.entity;

import io.leangen.graphql.annotations.GraphQLQuery;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author MW
 */
@Entity
@Table(name = "tb_document_area_comment")
public class DocumentAreaComment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @GraphQLQuery(name = "id")
    private Long id;

    @Column(name = "comment", length = 1000, nullable = false)
    @GraphQLQuery(name = "comment")
    private String comment;

    @Column(name = "create_date")
    @GraphQLQuery(name = "createDate")
    private LocalDateTime createDate;

    @Column(name = "update_date")
    @GraphQLQuery(name = "updateDate")
    private LocalDateTime updateDate = LocalDateTime.now();

    @Column(name = "document_area_id", insertable = false, updatable = false)
    @GraphQLQuery(name = "documentAreaId")
    private Long documentAreaId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "document_area_id", nullable = false)
    private DocumentArea documentArea;

    @GraphQLQuery(name = "user")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public LocalDateTime getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDateTime createDate) {
        this.createDate = createDate;
    }

    public LocalDateTime getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(LocalDateTime updateDate) {
        this.updateDate = updateDate;
    }

    public Long getDocumentAreaId() {
        return documentAreaId;
    }

    public void setDocumentAreaId(Long documentAreaId) {
        this.documentAreaId = documentAreaId;
    }

    public DocumentArea getDocumentArea() {
        return documentArea;
    }

    public void setDocumentArea(DocumentArea documentArea) {
        this.documentArea = documentArea;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

}
