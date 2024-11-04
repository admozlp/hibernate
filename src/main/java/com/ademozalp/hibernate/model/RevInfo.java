package com.ademozalp.hibernate.model;

import com.ademozalp.hibernate.config.AuditRevisionListener;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;
import org.hibernate.envers.DefaultRevisionEntity;
import org.hibernate.envers.RevisionEntity;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "revinfo")
@RevisionEntity(AuditRevisionListener.class)
public class RevInfo extends DefaultRevisionEntity {
    private String user;
}
