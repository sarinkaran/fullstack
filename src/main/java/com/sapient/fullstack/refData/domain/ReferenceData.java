package com.sapient.fullstack.refData.domain;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import lombok.Data;

@Data
@MappedSuperclass
public class ReferenceData {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	protected Long id;
	protected String code;
	protected String name;
	protected String description;
}
