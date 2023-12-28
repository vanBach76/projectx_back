package com.projectx.graphql.mutation;

import com.projectx.FileRepository;
import com.projectx.domain.Company;
import com.projectx.domain.CompanyInput;
import com.projectx.graphql.StaticRepository;
import graphql.kickstart.tools.GraphQLMutationResolver;
import org.springframework.stereotype.Component;

@Component
public class CompanyMutationResolver implements GraphQLMutationResolver {

    public int addCompany(CompanyInput companyInput) {
        Company company = new Company();
        company.setCurrency(companyInput.getCurrency());
        company.setName(companyInput.getName());
        company.setUser(StaticRepository.getUser(companyInput.getUserId()));
        return FileRepository.addCompany(company);
    }

}
