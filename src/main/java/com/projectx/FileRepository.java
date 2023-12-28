package com.projectx;

import com.projectx.domain.*;
import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.function.Predicate.not;

public class FileRepository {

    private static final List<User> USERS = new ArrayList<>();
    private static final List<Company> COMPANIES = new ArrayList<>();
    private static final List<ReportCard> REPORT_CARDS = new ArrayList<>();
    private static final List<ReportData> REPORT_DATA = new ArrayList<>();

    public static void init() {
        try {
            initUserData();
            initCompanyData();
            initReportDataForAllCompanies();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void initUserData() {
        User user = new User();
        user.setId(0);
        user.setName("karlback");
        USERS.add(user);
    }

    public static void initCompanyData() throws IOException {
        File dataDir = new File("data");
        File[] directories = dataDir.listFiles(File::isDirectory);
        if (directories == null) return;
        for (File directory : directories) {
            Company company = new Company();
            company.setName(directory.getName());
            company.setCurrency("sek"); //TODO: Get from data
            company.setUser(USERS.get(0)); // Only handle single user for now.
            COMPANIES.add(company);
        }
    }


    public static void initReportDataForAllCompanies() throws IOException {
        for (Company company : COMPANIES) {
            List<String> csv = Files.readAllLines(Path.of("data", company.getName(), "data.csv"));

            // Get the periods (i.e. quarters) from the top row to init the ReportCards.
            List<String> periods = Stream.of(csv.get(0).split(";"))
                    .filter(not(String::isEmpty))
                    .map(String::toLowerCase)
                    .collect(Collectors.toList());
            List<ReportCard> reportCards = getReportCardsForCompany(company, periods);
            REPORT_CARDS.addAll(reportCards);

            // For each ReportCard, load the corresponding data points.
            // Remove header and any empty rows to get only rows containing data.
            List<String> csvDataRows = csv.subList(1, csv.size()).stream()
                    .filter(row -> row != null && !row.isEmpty())
                    .collect(Collectors.toList());
            setReportData(csvDataRows, reportCards);
        }
    }

    private static List<ReportCard> getReportCardsForCompany(Company company, List<String> periods) {
        List<ReportCard> reportCards = new ArrayList<>();
        for (String period : periods) {
            String[] split = period.split(" ");
            String quarter = StringUtils.isNumeric(split[0]) ? split[1] : split[0];
            String year = split[1].equals(quarter) ? split[0] : split[1];

            ReportCard reportCard = new ReportCard();
            reportCard.setPeriod(PeriodEnum.valueOf(quarter));
            reportCard.setYear(Integer.parseInt(year));
            reportCard.setCompany(company);
            // Create some unique id - needed to properly render in the front-end
            int id = (company.getName() + reportCard.getPeriod() + reportCard.getYear()).hashCode();
            reportCard.setId(id);
            reportCards.add(reportCard);
        }
        return reportCards;
    }

    private static void setReportData(List<String> csvDataRows, List<ReportCard> reportCards) {
        for (String row : csvDataRows) {
            // Get the name of this data point from the first column.
            List<String> values = Arrays.asList(row.split(";"));
            String dataFieldName = values.get(0);
            // Then add quarterly data for this data point for each period.
            for (int i = 0; i < reportCards.size(); i++) {
                ReportData reportData = new ReportData();
                reportData.setDataFieldName(dataFieldName);
                // Add 1 to index to make sure quarters match up.
                reportData.setDataFieldValue(Double.parseDouble(values.get(i + 1)));
                ReportCard reportCard = reportCards.get(i);
                reportData.setReportCard(reportCard);
                // Create some unique id - needed to properly render in the front-end
                int id = (dataFieldName + reportCard.getId()).hashCode();
                reportData.setId(id);
                REPORT_DATA.add(reportData);
            }
        }
    }

    public static User getUser(int id ) {
        return USERS
                .stream()
                .filter(user -> id == user.getId())
                .findFirst()
                .orElse(null);
    }

    public static List<ReportCard> getReportCards(Company company) {
        return REPORT_CARDS.stream()
                .filter(reportCard -> reportCard.getCompany().equals(company))
                .collect(Collectors.toList());
    }

    public static List<ReportData> getReportDatas(ReportCard reportCard) {
        return REPORT_DATA
                .stream()
                .filter(reportData -> reportData.getReportCard().equals(reportCard))
                .collect(Collectors.toList());
    }
    public static List<Company> getCompanies(User user) {
        return COMPANIES
                .stream()
                .filter(company -> company.getUser().equals(user))
                .collect(Collectors.toList());
    }

    public static int addCompany(Company company) {
        company.setId(COMPANIES.size());
        COMPANIES.add(company);
        return company.getId();
    }

}
