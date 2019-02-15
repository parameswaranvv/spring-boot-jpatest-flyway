package com.example.jpatest.datajpatest.model;

import com.example.jpatest.datajpatest.helper.JsonBinaryType;
import com.example.jpatest.datajpatest.helper.JsonStringType;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;

import javax.persistence.MappedSuperclass;

@TypeDefs({
        @TypeDef(name = "json", typeClass = JsonStringType.class),
        @TypeDef(name = "jsonb", typeClass = JsonBinaryType.class)
})
@MappedSuperclass
public class BaseEntity { }
