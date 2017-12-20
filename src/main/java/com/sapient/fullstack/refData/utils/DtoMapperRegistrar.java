package com.sapient.fullstack.refData.utils;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.ClassPathScanningCandidateComponentProvider;
import org.springframework.core.type.filter.AnnotationTypeFilter;
import org.springframework.stereotype.Component;

import com.sapient.fullstack.refData.dto.Dto;
import com.sapient.fullstack.refData.metadata.Mapper;

@Component
public class DtoMapperRegistrar {
	
	private Map<String , Class<? extends Dto>> mappers =  new HashMap<>();
	
	@PostConstruct
	public void registrarMappers() throws Exception {
		ClassPathScanningCandidateComponentProvider scanner  =  new ClassPathScanningCandidateComponentProvider(false);
		scanner.addIncludeFilter(new AnnotationTypeFilter(Mapper.class));
		for(BeanDefinition bean : scanner.findCandidateComponents("com.sapient.fullstack.refData.dto")){
			Class<? extends Dto> clDto = (Class<? extends Dto>) Class.forName(bean.getBeanClassName());
			Mapper mapperAnnotation	 = clDto.getAnnotation(Mapper.class);
			String mapperOf = mapperAnnotation.of();
			mappers.put(mapperOf, clDto);
		}
	}
	
	
	public Class<? extends Dto>  getMapperClass(String code){
		return mappers.get(code);
	}
}
