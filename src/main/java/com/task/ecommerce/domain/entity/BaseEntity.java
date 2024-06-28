package com.task.ecommerce.domain.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.io.Serializable;
import java.util.Date;

@MappedSuperclass
@Data
public abstract class BaseEntity implements Serializable {

    @Column(nullable = false, name = "CREATED_BY", columnDefinition = "varchar(100)")
    private String createdBy;

    @Column(name = "UPDATED_BY", columnDefinition = "varchar(100)")
    private String updatedBy;

    @Column(name = "APPROVED_BY", columnDefinition = "varchar(100)")
    private String approvedBy;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "CREATED_DATE")
    private Date createdDate;

    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "UPDATED_DATE")
    private Date updatedDate;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "APPROVED_DATE")
    private Date approvedDate;

    @Version
    @Column(name = "VERSION")
    private Long version;

    @Column(name = "DDL_VERSION")
    private Integer ddlVersion;
}
