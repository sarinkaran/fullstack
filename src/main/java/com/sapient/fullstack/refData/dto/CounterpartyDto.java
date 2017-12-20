package com.sapient.fullstack.refData.dto;

import com.sapient.fullstack.refData.metadata.Mapper;

import lombok.Data;

@Data
@Mapper(of="counterparty")
public class CounterpartyDto implements Dto {
	
	protected String code;
	protected String name;
	protected String description;
	
}
