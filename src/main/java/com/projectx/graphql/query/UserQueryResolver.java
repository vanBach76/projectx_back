package com.projectx.graphql.query;

import com.projectx.domain.User;
import com.projectx.graphql.StaticRepository;
import graphql.kickstart.tools.GraphQLQueryResolver;
import org.springframework.stereotype.Component;

@Component
public class UserQueryResolver implements GraphQLQueryResolver {

    public User getUserById(int id) {
        return StaticRepository.getUser(id);
    }

}
