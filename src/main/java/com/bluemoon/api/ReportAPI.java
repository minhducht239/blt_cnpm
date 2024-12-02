package com.bluemoon.api;

import com.bluemoon.service.ReportService;

public class ReportAPI {
    private ReportService reportService;

    public ReportAPI() {
        this.reportService = new ReportService();
    }

    public void generateMonthlyReport() {
        reportService.generateMonthlyReport();
    }

    // Add more methods as needed
}