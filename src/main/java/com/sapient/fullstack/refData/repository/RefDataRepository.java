package com.sapient.fullstack.refData.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;

import com.sapient.fullstack.refData.domain.ReferenceData;

@NoRepositoryBean
public interface RefDataRepository <T extends ReferenceData> extends CrudRepository<T, Long> {
	  
	  @Query("select u from #{#entityName} as u where u.code = ?1 ")
	  Optional<ReferenceData> findByCode(String code);
}
