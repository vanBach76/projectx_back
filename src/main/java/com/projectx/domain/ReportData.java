package com.projectx.domain;

import java.util.Objects;

public class ReportData {

    private int id;
    private String dataFieldName;
    private double dataFieldValue;
    private ReportCard reportCard;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDataFieldName() {
        return dataFieldName;
    }

    public void setDataFieldName(String dataFieldName) {
        this.dataFieldName = dataFieldName;
    }

    public double getDataFieldValue() {
        return dataFieldValue;
    }

    public void setDataFieldValue(double dataFieldValue) {
        this.dataFieldValue = dataFieldValue;
    }


    public ReportCard getReportCard() {
        return reportCard;
    }

    public void setReportCard(ReportCard reportCard) {
        this.reportCard = reportCard;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ReportData that = (ReportData) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
