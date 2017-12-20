package com.sapient.fullstack.refData.service;

import java.util.Optional;

import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import com.sapient.fullstack.refData.Model.BusinessError;
import com.sapient.fullstack.refData.domain.ReferenceData;
import com.sapient.fullstack.refData.exceptions.BusinessException;
import com.sapient.fullstack.refData.repository.RefDataRepository;
import com.sapient.fullstack.refData.utils.RepositoryRegistrar;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ReferenceDataService extends ServiceSupport {
	
	
	public ReferenceData getReferenceDataByCode(String referenceDataObject , String code) throws Exception{
		
		RefDataRepository refDataRepository = (RefDataRepository)RepositoryRegistrar.getRepository(referenceDataObject);
		Optional<ReferenceData> refData = refDataRepository.findByCode(code);
		ReferenceData refDataObj = refData.orElseThrow(()-> new BusinessException(BusinessError.error("Reference data not found")));
		return refDataObj;
	}

}
