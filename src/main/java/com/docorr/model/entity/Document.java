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
import org.hibernate.annotations.Type;

/**
 *
 * @author MW
 */
@Entity
@Table(name = "tb_document")
public class Document {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @GraphQLQuery(name = "id")
    private Long id;

    @Column(name = "title", length = 255)
    @GraphQLQuery(name = "title")
    private String title;

    @Column(name = "content")
    @Type(type = "text")
    @GraphQLQuery(name = "content")
    private String content;

    @Column(name = "create_date")
    @GraphQLQuery(name = "createDate")
    private LocalDateTime createDate;

    @Column(name = "update_date")
    @GraphQLQuery(name = "updateDate")
    private LocalDateTime updateDate = LocalDateTime.now();

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "document")
    private List<DocumentArea> documentAreas = new ArrayList<>();

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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
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

    public List<DocumentArea> getDocumentAreas() {
        return documentAreas;
    }

    public void setDocumentAreas(List<DocumentArea> documentAreas) {
        this.documentAreas = documentAreas;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

}
