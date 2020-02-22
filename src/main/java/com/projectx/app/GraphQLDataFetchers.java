package com.projectx.app;

import com.projectx.dao.Company;
import com.projectx.dao.ReportCard;
import com.projectx.dao.ReportData;
import com.projectx.dao.User;
import graphql.schema.DataFetcher;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.stream.Collectors;

@Component // Needed since we're auto wiring this class in GraphQLProvider
public class GraphQLDataFetchers {

    public DataFetcher<User> getUserByIdDataFetcher() {
        return dataFetchingEnvironment -> {
            int id = Integer.parseInt(dataFetchingEnvironment.getArgument("id"));
            return StaticRepository.users
                    .stream()
                    .filter(user -> id == user.getId())
                    .findFirst()
                    .orElse(null);
        };
    }

    public DataFetcher<List<Company>> getCompaniesDataFetcher() {
        return dataFetchingEnvironment -> {
            User user = dataFetchingEnvironment.getSource();
            return StaticRepository.companies
                    .stream()
                    .filter(company -> user.getId() == company.getUserId())
                    .collect(Collectors.toList());
        };
    }

    public DataFetcher<List<ReportCard>> getReportCardsDataFetcher() {
        return dataFetchingEnvironment -> {
          Company company = dataFetchingEnvironment.getSource();
          return StaticRepository.reportCards
                  .stream()
                  .filter(reportCard -> company.getId() == reportCard.getCompanyId())
                  .collect(Collectors.toList());
        };
    }

    public DataFetcher<List<ReportData>> getReportDataDataFetcher() {
        return dataFetchingEnvironment -> {
            ReportCard reportCard = dataFetchingEnvironment.getSource();
            return StaticRepository.reportDatas
                    .stream()
                    .filter(reportData -> reportCard.getId() == reportData.getReportCardId())
                    .collect(Collectors.toList());
        };
    }

    @PostConstruct
    public void intiStaticRepository() {
        StaticRepository.init();
    }

}
