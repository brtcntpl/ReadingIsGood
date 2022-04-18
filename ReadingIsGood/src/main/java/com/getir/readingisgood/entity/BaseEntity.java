package com.getir.readingisgood.entity;


import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.io.Serializable;

import javax.persistence.*;
import java.util.Date;

@MappedSuperclass
@Data
public class BaseEntity implements Serializable, Cloneable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    protected Long id;

    @Column(name = "created_date", nullable = false)
    @CreatedDate
    protected Date createdDate;

    @LastModifiedDate
    @Column(name = "last_modified_date", nullable = false)
    protected Date lastModifiedDate;

    @Override
    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException ignored) {
            return null;
        }
    }

    @PrePersist
    public void onCreate() {
        this.createdDate = new Date();
        this.lastModifiedDate = new Date();
    }

    @PreUpdate
    public void onUpdate() {
        this.lastModifiedDate = new Date();
    }

}
