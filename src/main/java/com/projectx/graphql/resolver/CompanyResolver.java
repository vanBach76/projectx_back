package com.projectx.graphql.resolver;

import com.projectx.FileRepository;
import com.projectx.domain.Company;
import com.projectx.domain.ReportCard;
import com.projectx.domain.User;
import com.projectx.graphql.StaticRepository;
import graphql.kickstart.tools.GraphQLResolver;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CompanyResolver implements GraphQLResolver<Company> {

    public User user(Company company) {
        return company.getUser();
    }

    public List<ReportCard> reportCards(Company company) {
        return FileRepository.getReportCards(company);
    }
}
