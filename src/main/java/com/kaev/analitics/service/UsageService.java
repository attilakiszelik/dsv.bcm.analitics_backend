package com.kaev.analitics.service;

import java.io.Console;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.kaev.analitics.model.ReportRow;
import com.kaev.analitics.model.UsageLogEntry;
import com.kaev.analitics.repository.UsageRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UsageService {

	private final UsageRepository usageRepository;
	private final Initialize initialize;
	
	public List<ReportRow> createReport(String year){
		
		List<UsageLogEntry> logEntries = usageRepository.findAllInYear(year);

		List<ReportRow> reportRows = new ArrayList<ReportRow>();;
		
		logEntries.forEach(l -> {
			
			//miden sor esetében a szükséges változók rögzítése
			String project = l.getProject();
			int month = Integer.parseInt(l.getTimestamp().substring(4,6));
			int index = month-1;
			String user = l.getUsername();
			
			Optional<ReportRow> existingReportRow = reportRows.stream().filter(r -> r.getProject().equals(project)).findFirst();
			
			if (existingReportRow.isPresent()) {
				
				ReportRow r = existingReportRow.get();
				
				//használat növelée
				r.setUsagesInTheMonth(index, r.getUsagesInTheMonth(index) + 1); 
				//használó hozzáadása, ha még nem szerepel
				if(!r.getUsersInTheMonth(index).contains(user)) {
					r.setUsersInTheMonth(index, user);
				}	
				
			} else {
				
				//ha a projektnek nincs még riport sora
				ReportRow newReportRow = initialize.newRepotRow();
				newReportRow.setProject(project);
				newReportRow.setUsagesInTheMonth(index, 1);
				newReportRow.setUsersInTheMonth(index, user);
				reportRows.add(newReportRow);
				
			}
			
		});
		
		return reportRows;
		
	}

}
