package com.projectx.graphql.resolver;

import com.projectx.domain.Company;
import com.projectx.domain.User;
import com.projectx.graphql.StaticRepository;
import graphql.kickstart.tools.GraphQLResolver;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserResolver implements GraphQLResolver<User> {

    public List<Company> companies(User user) {
        return StaticRepository.getCompanies(user);
    }

}
