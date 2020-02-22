package com.projectx.dao;

import java.util.Objects;

public class ReportData {

    private int id;
    private int reportCardId;
    private String dataFieldName;
    private double dataFieldValue;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getReportCardId() {
        return reportCardId;
    }

    public void setReportCardId(int reportCardId) {
        this.reportCardId = reportCardId;
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
