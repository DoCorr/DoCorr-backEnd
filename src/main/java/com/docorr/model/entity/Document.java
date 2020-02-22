package com.docorr.model.entity;

import io.leangen.graphql.annotations.GraphQLQuery;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
    private LocalDateTime updateDate;

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

    @Override
    public String toString() {
        return "Document{" + "id=" + id + ", title=" + title + ", content=" + content + ", createDate=" + createDate + ", updateDate=" + updateDate + '}';
    }

}
