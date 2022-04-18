package com.getir.readingisgood.entity;

import lombok.*;
import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Entity
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Table(name = "BOOK_HISTORY")
public class BookHistory extends BaseHistoryEntity {

}
