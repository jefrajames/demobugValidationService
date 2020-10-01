package org.jefrajames.graphql;

import org.eclipse.microprofile.graphql.GraphQLApi;
import org.eclipse.microprofile.graphql.Query;

@GraphQLApi
public class HelloGraphQL {

    @Query
    public String hello() {
        return "hello from GraphQL";
    }

    
} 
