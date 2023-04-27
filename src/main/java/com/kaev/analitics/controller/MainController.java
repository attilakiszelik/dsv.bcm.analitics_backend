package com.kaev.analitics.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
	@GetMapping("/supporthours/{year}")
	public List<ReportRow> getSupporthours(@PathVariable String year){
		return supporthourService.createReport(year);
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/usages/{year}")
	public List<ReportRow> getUsages(@PathVariable String year){
		return usageService.createReport(year);
	}
	
    @GetMapping("/ip")
    public String getIpAddress(HttpServletRequest request) {
    
	    String containersIP = request.getRemoteAddr();
	    return "the container's IP address is: " + containersIP;
    
    }
	
}