package com.sapient.fullstack.refData.dto;

import com.sapient.fullstack.refData.metadata.Mapper;

import lombok.Data;

@Data
@Mapper(of="location")
public class LocationDto implements Dto {
	
	protected String code;
	protected String name;
	protected String description;
	
}
