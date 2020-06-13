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

        Company bahnhof = new Company();
        bahnhof.setId(0);
        bahnhof.setUserId(user.getId());
        bahnhof.setName("Bahnhof AB");
        bahnhof.setCurrency("SEK");

        ReportCard q1Bahn2018 = new ReportCard();
        q1Bahn2018.setId(-1);
        q1Bahn2018.setCompanyId(bahnhof.getId());
        q1Bahn2018.setYear(2018);
        q1Bahn2018.setPeriod(PeriodEnum.Q1);
        q1Bahn2018.setComment("Looking good!");

        ReportData q1Bahn2018Eps = new ReportData();
        q1Bahn2018Eps.setId(-1);
        q1Bahn2018Eps.setReportCardId(q1Bahn2018.getId());
        q1Bahn2018Eps.setDataFieldName("EPS");
        q1Bahn2018Eps.setDataFieldValue(1.95);

        ReportData q1Bahn2018Sales = new ReportData();
        q1Bahn2018Sales.setId(5);
        q1Bahn2018Sales.setReportCardId(q1Bahn2018.getId());
        q1Bahn2018Sales.setDataFieldName("Sales");
        q1Bahn2018Sales.setDataFieldValue(250000000);

        ReportData q1Bahn2018Equity = new ReportData();
        q1Bahn2018Equity.setId(6);
        q1Bahn2018Equity.setReportCardId(q1Bahn2018.getId());
        q1Bahn2018Equity.setDataFieldName("Equity");
        q1Bahn2018Equity.setDataFieldValue(300000000);

        ReportCard q1Bahn2019 = new ReportCard();
        q1Bahn2019.setId(0);
        q1Bahn2019.setCompanyId(bahnhof.getId());
        q1Bahn2019.setYear(2019);
        q1Bahn2019.setPeriod(PeriodEnum.Q1);
        q1Bahn2019.setComment("We're going down...");

        ReportData q1Bahn2019Eps = new ReportData();
        q1Bahn2019Eps.setId(0);
        q1Bahn2019Eps.setReportCardId(q1Bahn2019.getId());
        q1Bahn2019Eps.setDataFieldName("EPS");
        q1Bahn2019Eps.setDataFieldValue(2.43);

        ReportCard q2Bahn2019 = new ReportCard();
        q2Bahn2019.setId(1);
        q2Bahn2019.setCompanyId(bahnhof.getId());
        q2Bahn2019.setYear(2019);
        q2Bahn2019.setPeriod(PeriodEnum.Q2);
        q2Bahn2019.setComment("We're going up!");

        ReportData q2Bahn2019Eps = new ReportData();
        q2Bahn2019Eps.setId(1);
        q2Bahn2019Eps.setReportCardId(q2Bahn2019.getId());
        q2Bahn2019Eps.setDataFieldName("EPS");
        q2Bahn2019Eps.setDataFieldValue(2.75);

        ReportCard q3Bahn2019 = new ReportCard();
        q3Bahn2019.setId(2);
        q3Bahn2019.setCompanyId(bahnhof.getId());
        q3Bahn2019.setYear(2019);
        q3Bahn2019.setPeriod(PeriodEnum.Q3);
        q3Bahn2019.setComment("We're going down...");

        ReportData q3Bahn2019Eps = new ReportData();
        q3Bahn2019Eps.setId(2);
        q3Bahn2019Eps.setReportCardId(q3Bahn2019.getId());
        q3Bahn2019Eps.setDataFieldName("EPS");
        q3Bahn2019Eps.setDataFieldValue(2.10);

        ReportCard q4Bahn2019 = new ReportCard();
        q4Bahn2019.setId(3);
        q4Bahn2019.setCompanyId(bahnhof.getId());
        q4Bahn2019.setYear(2019);
        q4Bahn2019.setPeriod(PeriodEnum.Q4);
        q4Bahn2019.setComment("We're going up again!");

        ReportCard q1Bahn2020 = new ReportCard();
        q1Bahn2020.setId(20);
        q1Bahn2020.setCompanyId(bahnhof.getId());
        q1Bahn2020.setYear(2020);
        q1Bahn2020.setPeriod(PeriodEnum.Q1);
        q1Bahn2020.setComment("Jättebra!");

        ReportData q4Bahn2019Eps = new ReportData();
        q4Bahn2019Eps.setId(3);
        q4Bahn2019Eps.setReportCardId(q4Bahn2019.getId());
        q4Bahn2019Eps.setDataFieldName("EPS");
        q4Bahn2019Eps.setDataFieldValue(3.10);

        Company apple = new Company();
        apple.setId(1);
        apple.setUserId(user.getId());
        apple.setName("Apple");
        apple.setCurrency("USD");

        ReportCard q1Apple2019 = new ReportCard();
        q1Apple2019.setId(4);
        q1Apple2019.setCompanyId(apple.getId());
        q1Apple2019.setYear(2019);
        q1Apple2019.setPeriod(PeriodEnum.Q4);
        q1Apple2019.setComment("Nice margins.");

        ReportData q1Apple2019Eps = new ReportData();
        q1Apple2019Eps.setId(4);
        q1Apple2019Eps.setReportCardId(q1Apple2019.getId());
        q1Apple2019Eps.setDataFieldName("EPS");
        q1Apple2019Eps.setDataFieldValue(14.10);

        users = Arrays.asList(user);
        companies = Arrays.asList(bahnhof, apple);
        reportCards = Arrays.asList(q1Bahn2018, q1Bahn2019, q2Bahn2019, q3Bahn2019, q4Bahn2019, q1Apple2019,q1Bahn2020);
        reportDatas = Arrays.asList(q1Bahn2018Eps,
                q1Bahn2019Eps,
                q2Bahn2019Eps,
                q3Bahn2019Eps,
                q4Bahn2019Eps,
                q1Apple2019Eps,
                q1Bahn2018Sales,
                q1Bahn2018Equity);

    }


}
