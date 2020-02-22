package com.projectx.app;

import com.google.common.base.Charsets;
import com.google.common.io.Resources;
import graphql.GraphQL;
import graphql.schema.GraphQLSchema;
import graphql.schema.idl.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.net.URL;

import static graphql.schema.idl.TypeRuntimeWiring.*;

@Component
public class GraphQLProvider {

    private GraphQL graphQL;

    @Autowired
    GraphQLDataFetchers graphQLDataFetchers;

    // The GraphQL Java Spring adapter will use the GraphQL instance to make
    // our schema available via HTTP on the default url /graphql.
    @Bean
    public GraphQL graphQL() {
        return graphQL;
    }

    @PostConstruct
    public void init() throws IOException {
        URL url = Resources.getResource("schema.graphqls");
        String sdl = Resources.toString(url, Charsets.UTF_8);
        GraphQLSchema graphQLSchema = buildSchema(sdl);
        this.graphQL = GraphQL.newGraphQL(graphQLSchema).build();
    }

    private GraphQLSchema buildSchema(String sdl) {
        TypeDefinitionRegistry typeRegistry = new SchemaParser().parse(sdl);
        RuntimeWiring runtimeWiring = buildWiring();
        SchemaGenerator schemaGenerator = new SchemaGenerator();
        return schemaGenerator.makeExecutableSchema(typeRegistry, runtimeWiring);
    }

    private RuntimeWiring buildWiring() {
        return RuntimeWiring.newRuntimeWiring()
                .type(newTypeWiring("Query")
                        .dataFetcher("userById", graphQLDataFetchers.getUserByIdDataFetcher()))
                .type(newTypeWiring("User")
                        .dataFetcher("companies", graphQLDataFetchers.getCompaniesDataFetcher()))
                .type(newTypeWiring("Company")
                        .dataFetcher("reportCards", graphQLDataFetchers.getReportCardsDataFetcher()))
                .type(newTypeWiring("ReportCard")
                        .dataFetcher("reportData", graphQLDataFetchers.getReportDataDataFetcher()))
                .build();
    }


}
