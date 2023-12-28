package com.projectx.graphql;

import com.projectx.domain.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


public class StaticRepository {

    private static final List<User> users = new ArrayList<>();
    private static final List<Company> companies = new ArrayList<>();
    private static final List<ReportCard> reportCards = new ArrayList<>();
    private static final List<ReportData> reportDatas = new ArrayList<>();

    public static void init() {

        User user = new User();
        user.setId(0);
        user.setName("karlback");

        Company bahnhof = new Company();
        bahnhof.setId(0);
        bahnhof.setUser(user);
        bahnhof.setName("Bahnhof AB");
        bahnhof.setCurrency("SEK");

        ReportCard q1Bahn2018 = new ReportCard();
        q1Bahn2018.setId(-1);
        q1Bahn2018.setCompany(bahnhof);
        q1Bahn2018.setYear(2018);
        q1Bahn2018.setPeriod(PeriodEnum.q1);
        q1Bahn2018.setComment("Looking good!");

        ReportData q1Bahn2018Eps = new ReportData();
        q1Bahn2018Eps.setId(-1);
        q1Bahn2018Eps.setReportCard(q1Bahn2018);
        q1Bahn2018Eps.setDataFieldName("EPS");
        q1Bahn2018Eps.setDataFieldValue(1.95);

        ReportData q1Bahn2018Sales = new ReportData();
        q1Bahn2018Sales.setId(5);
        q1Bahn2018Sales.setReportCard(q1Bahn2018);
        q1Bahn2018Sales.setDataFieldName("Sales");
        q1Bahn2018Sales.setDataFieldValue(250000000);

        ReportData q1Bahn2018Equity = new ReportData();
        q1Bahn2018Equity.setId(6);
        q1Bahn2018Equity.setReportCard(q1Bahn2018);
        q1Bahn2018Equity.setDataFieldName("Equity");
        q1Bahn2018Equity.setDataFieldValue(300000000);

        ReportCard q1Bahn2019 = new ReportCard();
        q1Bahn2019.setId(0);
        q1Bahn2019.setCompany(bahnhof);
        q1Bahn2019.setYear(2019);
        q1Bahn2019.setPeriod(PeriodEnum.q1);
        q1Bahn2019.setComment("We're going down...");

        ReportData q1Bahn2019Eps = new ReportData();
        q1Bahn2019Eps.setId(0);
        q1Bahn2019Eps.setReportCard(q1Bahn2019);
        q1Bahn2019Eps.setDataFieldName("EPS");
        q1Bahn2019Eps.setDataFieldValue(2.43);

        ReportCard q2Bahn2019 = new ReportCard();
        q2Bahn2019.setId(1);
        q2Bahn2019.setCompany(bahnhof);
        q2Bahn2019.setYear(2019);
        q2Bahn2019.setPeriod(PeriodEnum.q2);
        q2Bahn2019.setComment("We're going up!");

        ReportData q2Bahn2019Eps = new ReportData();
        q2Bahn2019Eps.setId(1);
        q2Bahn2019Eps.setReportCard(q2Bahn2019);
        q2Bahn2019Eps.setDataFieldName("EPS");
        q2Bahn2019Eps.setDataFieldValue(2.75);

        ReportCard q3Bahn2019 = new ReportCard();
        q3Bahn2019.setId(2);
        q3Bahn2019.setCompany(bahnhof);
        q3Bahn2019.setYear(2019);
        q3Bahn2019.setPeriod(PeriodEnum.q3);
        q3Bahn2019.setComment("We're going down...");

        ReportData q3Bahn2019Eps = new ReportData();
        q3Bahn2019Eps.setId(2);
        q3Bahn2019Eps.setReportCard(q3Bahn2019);
        q3Bahn2019Eps.setDataFieldName("EPS");
        q3Bahn2019Eps.setDataFieldValue(2.10);

        ReportCard q4Bahn2019 = new ReportCard();
        q4Bahn2019.setId(3);
        q4Bahn2019.setCompany(bahnhof);
        q4Bahn2019.setYear(2019);
        q4Bahn2019.setPeriod(PeriodEnum.q4);
        q4Bahn2019.setComment("We're going up again!");

        ReportCard q1Bahn2020 = new ReportCard();
        q1Bahn2020.setId(20);
        q1Bahn2020.setCompany(bahnhof);
        q1Bahn2020.setYear(2020);
        q1Bahn2020.setPeriod(PeriodEnum.q1);
        q1Bahn2020.setComment("Jättebra!");

        ReportData q4Bahn2019Eps = new ReportData();
        q4Bahn2019Eps.setId(3);
        q4Bahn2019Eps.setReportCard(q4Bahn2019);
        q4Bahn2019Eps.setDataFieldName("EPS");
        q4Bahn2019Eps.setDataFieldValue(3.10);

        Company apple = new Company();
        apple.setId(1);
        apple.setUser(user);
        apple.setName("Apple");
        apple.setCurrency("USD");

        ReportCard q1Apple2019 = new ReportCard();
        q1Apple2019.setId(4);
        q1Apple2019.setCompany(apple);
        q1Apple2019.setYear(2019);
        q1Apple2019.setPeriod(PeriodEnum.q4);
        q1Apple2019.setComment("Nice margins.");

        ReportData q1Apple2019Eps = new ReportData();
        q1Apple2019Eps.setId(4);
        q1Apple2019Eps.setReportCard(q1Apple2019);
        q1Apple2019Eps.setDataFieldName("EPS");
        q1Apple2019Eps.setDataFieldValue(14.10);

        users.addAll(Arrays.asList(user));
        companies.addAll(Arrays.asList(bahnhof, apple));
        reportCards.addAll(Arrays.asList(q1Bahn2018, q1Bahn2019, q2Bahn2019, q3Bahn2019, q4Bahn2019, q1Apple2019,q1Bahn2020));
        reportDatas.addAll(Arrays.asList(q1Bahn2018Eps,
                q1Bahn2019Eps,
                q2Bahn2019Eps,
                q3Bahn2019Eps,
                q4Bahn2019Eps,
                q1Apple2019Eps,
                q1Bahn2018Sales,
                q1Bahn2018Equity));

    }

    public static User getUser(int id ) {
        return users
                .stream()
                .filter(user -> id == user.getId())
                .findFirst()
                .orElse(null);
    }

    public static List<ReportCard> getReportCards(Company company) {
        return reportCards.stream()
                .filter(reportCard -> reportCard.getCompany().equals(company))
                .collect(Collectors.toList());
    }

    public static List<ReportData> getReportDatas(ReportCard reportCard) {
        return reportDatas
                .stream()
                .filter(reportData -> reportData.getReportCard().equals(reportCard))
                .collect(Collectors.toList());
    }
    public static List<Company> getCompanies(User user) {
        return companies
                .stream()
                .filter(company -> company.getUser().equals(user))
                .collect(Collectors.toList());
    }

    public static int addCompany(Company company) {
        company.setId(companies.size());
        companies.add(company);
        return company.getId();
    }


}
