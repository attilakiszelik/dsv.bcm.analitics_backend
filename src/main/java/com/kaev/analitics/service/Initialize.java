package com.kaev.analitics.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.kaev.analitics.model.ReportRow;

@Service
public class Initialize {

	public ReportRow newRepotRow() {
		
		List<Double> supporthours = new ArrayList<Double>();
			for (int i=0; i<=11; i++)
				supporthours.add(0.00);
		List<Integer> usages = new ArrayList<Integer>();
			for (int i=0; i<=11; i++)
				usages.add(0);
		Map<Integer, List<String>> users = new HashMap<Integer, List<String>>();
			for (int i=0; i<=11; i++)
				users.put(i, new ArrayList<String>());

		return new ReportRow("",supporthours, usages, users);
		
	}
	
}