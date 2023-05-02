package com.kaev.analitics.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.kaev.analitics.model.ReportRow;
import com.kaev.analitics.model.SupporthoursLogEntry;
import com.kaev.analitics.repository.SupporthourRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SupporthourService {

	private final SupporthourRepository supporthourRepository;
	private final Initialize initialize;
	
	public List<ReportRow> createReport(String year){
		
		List<SupporthoursLogEntry> logEntries = supporthourRepository.findAllInYear(year);

		List<ReportRow> reportRows = new ArrayList<ReportRow>();;
		
		logEntries.forEach(l -> {
			
			//miden sor esetében a szükséges változók rögzítése
			String project = l.getProject();
			int month = Integer.parseInt(l.getTimestamp().substring(4,6));
			int index = month-1;
			double workminutes = (double) l.getWorkminutes();
			
			Optional<ReportRow> existingReportRow = reportRows.stream().filter(r -> r.getProjectname().equals(project)).findFirst();
			
			if (existingReportRow.isPresent()) {
				
				ReportRow r = existingReportRow.get();
				
				//munkaórák számának növelése
				r.setSupporthours(index, Math.round(r.getSupporthours(index)*60 + workminutes)/60.00); 
				
			} else {
				
				//ha a projektnek nincs még riport sora
				ReportRow newReportRow = initialize.newRepotRow();
				newReportRow.setProjectname(project);
				newReportRow.setSupporthours(index, Math.round(workminutes/60.00));
				reportRows.add(newReportRow);
				
			}
			
		});
		
		return reportRows;
		
	}

}
