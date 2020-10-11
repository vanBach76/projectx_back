package com.projectx.domain;

import java.util.List;
import java.util.Objects;

public class Company {

    private int id;
    private String name;
    private String currency;
    private User user;
    private List<ReportCard> reportCards;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<ReportCard> getReportCards() {
        return reportCards;
    }

    public void setReportCards(List<ReportCard> reportCards) {
        this.reportCards = reportCards;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Company company = (Company) o;
        return id == company.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
