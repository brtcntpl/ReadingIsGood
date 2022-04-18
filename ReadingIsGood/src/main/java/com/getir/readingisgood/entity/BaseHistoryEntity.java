package com.getir.readingisgood.entity;



import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.Embedded;
import javax.persistence.MappedSuperclass;

@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@MappedSuperclass
public class BaseHistoryEntity extends BaseEntity {
    private Long mainEntityId;

    @Embedded
    private ChangeEntry changeEntry;
}