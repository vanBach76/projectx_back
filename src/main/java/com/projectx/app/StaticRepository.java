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

        ReportCard reportCard = new ReportCard();
        reportCard.setId(0);
        reportCard.setCompanyId(company0.getId());
        reportCard.setPeriod(PeriodEnum.Q1);
        reportCard.setComment("We're going down...");

        ReportData reportData = new ReportData();
        reportData.setId(0);
        reportData.setReportCardId(reportCard.getId());
        reportData.setDataFieldName("EPS");
        reportData.setDataFieldValue(2.43);

        users = Arrays.asList(user);
        companies = Arrays.asList(company0, company1);
        reportCards = Arrays.asList(reportCard);
        reportDatas = Arrays.asList(reportData);

    }


}
