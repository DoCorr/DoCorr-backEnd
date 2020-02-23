package com.docorr.model.entity;

import io.leangen.graphql.annotations.GraphQLQuery;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author MW
 */
@Entity
@Table(name = "tb_user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @GraphQLQuery(name = "id", description = "PK")
    private Integer id;

    @Column(name = "name", length = 255, nullable = false)
    @GraphQLQuery(name = "name", description = "User Name")
    private String name;

    @Column(name = "email", length = 255, nullable = false)
    @GraphQLQuery(name = "email", description = "email")
    private String email;

    @Column(name = "create_date")
    @GraphQLQuery(name = "createDate")
    private LocalDateTime createDate;

    @Column(name = "update_date")
    @GraphQLQuery(name = "updateDate")
    private LocalDateTime updateDate = LocalDateTime.now();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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
        return "User{" + "id=" + id + ", name=" + name + ", email=" + email + ", createDate=" + createDate + ", updateDate=" + updateDate + '}';
    }

}
