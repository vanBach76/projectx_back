package com.projectx.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ReportCard {

    private int id;
    private int year;
    private PeriodEnum period;
    private String comment;
    private Company company;
    private List<ReportData> reportDataList = new ArrayList<>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public PeriodEnum getPeriod() {
        return period;
    }

    public void setPeriod(PeriodEnum period) {
        this.period = period;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public List<ReportData> getReportDataList() {
        return reportDataList;
    }

    public void setReportDataList(List<ReportData> reportDataList) {
        this.reportDataList = reportDataList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ReportCard that = (ReportCard) o;
        return id == that.id
                && that.company != null && that.company.equals(this.company)
                && that.year == this.year
                && that.period == this.period;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
