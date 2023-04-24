package com.kaev.analitics.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "automationusage")
public class UsageLogEntry {
	
	@Id
	@GeneratedValue
	@EqualsAndHashCode.Include()
	private long id;
	
	private String project;
	private String type;
	private String process;
	private String timestamp;
	private String username;

}
