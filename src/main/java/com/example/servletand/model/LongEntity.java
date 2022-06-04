package com.example.servletand.model;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@EqualsAndHashCode
abstract public class LongEntity implements Entity<Long> {

  protected Long id;

}
