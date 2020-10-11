package com.projectx.graphql.resolver;

import com.projectx.domain.Company;
import com.projectx.domain.ReportCard;
import com.projectx.domain.ReportData;
import com.projectx.graphql.StaticRepository;
import graphql.kickstart.tools.GraphQLResolver;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.stream.Collectors;

@Component
public class ReportCardResolver implements GraphQLResolver<ReportCard> {

    public Company company(ReportCard reportCard) {
        return reportCard.getCompany();
    }

    public Collection<ReportData> reportData(ReportCard reportCard) {
        return StaticRepository.getReportDatas(reportCard);
    }

}
