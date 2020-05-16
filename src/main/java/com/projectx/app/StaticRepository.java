package com.projectx.app;

import com.projectx.dao.*;

import java.util.Arrays;
import java.util.List;


public class StaticRepository {

    static List<User> users;
    static List<Company> companies;
    static List<ReportCard> reportCards;
    static List<ReportData> reportDatas;

    public static void init() {

        User user = new User();
        user.setId(0);
        user.setName("karlback");

        Company company0 = new Company();
        company0.setId(0);
        company0.setUserId(user.getId());
        company0.setName("Bahnhof AB");
        company0.setCurrency("SEK");

        Company company1 = new Company();
        company1.setId(1);
        company1.setUserId(user.getId());
        company1.setName("Apple");
        company1.setCurrency("USD");

        ReportCard q1 = new ReportCard();
        q1.setId(0);
        q1.setCompanyId(company0.getId());
        q1.setYear(2019);
        q1.setPeriod(PeriodEnum.Q1);
        q1.setComment("We're going down...");

        ReportData reportDataQ1 = new ReportData();
        reportDataQ1.setId(0);
        reportDataQ1.setReportCardId(q1.getId());
        reportDataQ1.setDataFieldName("EPS");
        reportDataQ1.setDataFieldValue(2.43);

        ReportCard q2 = new ReportCard();
        q2.setId(1);
        q2.setCompanyId(company0.getId());
        q2.setYear(2019);
        q2.setPeriod(PeriodEnum.Q2);
        q2.setComment("We're going up!");

        ReportData reportDataQ2 = new ReportData();
        reportDataQ2.setId(1);
        reportDataQ2.setReportCardId(q2.getId());
        reportDataQ2.setDataFieldName("EPS");
        reportDataQ2.setDataFieldValue(2.75);

        ReportCard q3 = new ReportCard();
        q3.setId(2);
        q3.setCompanyId(company0.getId());
        q3.setYear(2019);
        q3.setPeriod(PeriodEnum.Q3);
        q3.setComment("We're going down...");

        ReportData reportDataQ3 = new ReportData();
        reportDataQ3.setId(2);
        reportDataQ3.setReportCardId(q3.getId());
        reportDataQ3.setDataFieldName("EPS");
        reportDataQ3.setDataFieldValue(2.10);

        ReportCard q4 = new ReportCard();
        q4.setId(3);
        q4.setCompanyId(company0.getId());
        q4.setYear(2019);
        q4.setPeriod(PeriodEnum.Q4);
        q4.setComment("We're going up again!");

        ReportData reportDataQ4 = new ReportData();
        reportDataQ4.setId(3);
        reportDataQ4.setReportCardId(q4.getId());
        reportDataQ4.setDataFieldName("EPS");
        reportDataQ4.setDataFieldValue(3.10);

        users = Arrays.asList(user);
        companies = Arrays.asList(company0, company1);
        reportCards = Arrays.asList(q1, q2, q3, q4);
        reportDatas = Arrays.asList(reportDataQ1, reportDataQ2, reportDataQ3, reportDataQ4);

    }


}
