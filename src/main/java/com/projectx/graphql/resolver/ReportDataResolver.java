package com.projectx.graphql.resolver;

import com.projectx.domain.ReportCard;
import com.projectx.domain.ReportData;
import graphql.kickstart.tools.GraphQLResolver;
import org.springframework.stereotype.Component;

@Component
public class ReportDataResolver implements GraphQLResolver<ReportData> {

    public ReportCard reportCard(ReportData reportData) {
        return reportData.getReportCard();
    }

}


