package com.kaev.analitics.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kaev.analitics.model.ReportRow;
import com.kaev.analitics.service.SupporthourService;
import com.kaev.analitics.service.UsageService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/analitics")
@RequiredArgsConstructor
public class MainController {

	private final SupporthourService supporthourService;
	private final UsageService usageService;
	
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/supporthours")
	public List<ReportRow> getSupporthours(){
		return supporthourService.createReport("2023");
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/usages")
	public List<ReportRow> getUsages(){
		return usageService.createReport("2023");
	}
	
}