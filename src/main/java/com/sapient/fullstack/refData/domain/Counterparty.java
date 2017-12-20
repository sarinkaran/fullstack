package com.sapient.fullstack.refData.domain;

import javax.persistence.Entity;

import com.sapient.fullstack.refData.metadata.Alias;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;

@Entity()
@AllArgsConstructor
@EqualsAndHashCode(of="id")
@Alias(name="counterparty")
public class Counterparty extends ReferenceData {
	
}
