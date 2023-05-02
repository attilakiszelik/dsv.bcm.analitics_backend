package com.kaev.analitics.model;

import java.util.List;
import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ReportRow {

	private String projectname;
	private List<Double> supporthours;
	private List<Integer> usages;
	private Map<Integer, List<String>> users;
	
	//supporthours
	public double getSupporthours(int index) {
		return this.supporthours.get(index);
	}

	public void setSupporthours(int index, double hours) {
		this.supporthours.set(index, hours);
	}
	
	//usages
	public int getUsagesInTheMonth(int index) {
		return this.usages.get(index);
	}
	
	public void setUsagesInTheMonth(int index, int value) {
		this.usages.set(index, value);
	}

	public List<String> getUsersInTheMonth(int index) {
		return this.users.get(index);
	}
	
	public void setUsersInTheMonth(int index, String user) {
		
		List<String> actualUsersInTheMonth = this.users.get(index);
		actualUsersInTheMonth.add(user);
		this.users.put(index, actualUsersInTheMonth);
		
	}
	
	public int getNumberOfUsersInTheMonth(int index) {
		
		List<String> actualUsersInTheMonth = this.users.get(index);
		return actualUsersInTheMonth.size();
		
	}
	
}