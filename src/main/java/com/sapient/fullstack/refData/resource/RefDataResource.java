package com.sapient.fullstack.refData.resource;

import org.modelmapper.ModelMapper;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sapient.fullstack.refData.domain.ReferenceData;
import com.sapient.fullstack.refData.dto.Dto;
import com.sapient.fullstack.refData.service.ReferenceDataService;
import com.sapient.fullstack.refData.utils.DtoMapperRegistrar;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/refData")
@AllArgsConstructor
public class RefDataResource {
	
	private ReferenceDataService refDataService;
	private ModelMapper modelMapper;
	private ApplicationContext context;
	private DtoMapperRegistrar mapperRegistrar;
	
	
	
	@RequestMapping("/{refDataObject}/list")
	public String testHelloWorld() {
		return "helloWorld";
		
	}
	
	@RequestMapping("/{refDataObject}/{code}")
	public Dto getReferenceDatabyCode(@PathVariable String refDataObject , @PathVariable String code) throws Exception{
		ReferenceData refDataEntity =  refDataService.getReferenceDataByCode(refDataObject, code);
		Class<? extends Dto> clMapper = mapperRegistrar.getMapperClass(refDataObject);
		Dto dto = modelMapper.map(refDataEntity, clMapper);
		return dto;
	}
}
