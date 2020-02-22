package com.docorr.dao;

import com.docorr.model.entity.Document;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author MW
 */
public interface DocumentDao extends JpaRepository<Document, Long> {
}
