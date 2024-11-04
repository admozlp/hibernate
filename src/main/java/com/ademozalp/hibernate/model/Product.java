package com.ademozalp.hibernate.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.envers.Audited;
import org.hibernate.envers.RelationTargetAuditMode;

import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@Table(name = "products")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
//@org.hibernate.annotations.Cache(region = "products", usage = CacheConcurrencyStrategy.READ_WRITE)
@Audited
public class Product implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(length = 100)
    private String id;

    private BigDecimal price;

    @Embedded
    private Detail detail;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH}, fetch = FetchType.LAZY)
    @JoinColumn(name = "categoryId")
    @JsonBackReference
    private Category category;

    private Integer stock;

//    @Version
//    private Integer version;
}
