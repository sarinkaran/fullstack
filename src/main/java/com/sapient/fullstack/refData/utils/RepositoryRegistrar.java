package com.sapient.fullstack.refData.utils;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.context.ApplicationContext;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.support.Repositories;
import org.springframework.stereotype.Component;

import com.sapient.fullstack.refData.metadata.Alias;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class RepositoryRegistrar {
	
	private static final Map<String, Repository> repositories =  new HashMap<>();
	private ApplicationContext context;
	
	@PostConstruct
	public void ResigterRepositories() {
		Repositories repos =  new Repositories(context);
		repos.forEach(r->{
			Class entityClass = r;
			Repository repoBean =   (Repository) repos.getRepositoryFor(r);
			Alias alias = (Alias) entityClass.getAnnotation(Alias.class);
			repositories.put(alias.name(), repoBean);
		});
	}
	
	public static Repository getRepository(String repoName) {
		return repositories.get(repoName);
	}
}
