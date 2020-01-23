package com.concon.simpleprojekt.source;


import com.concon.simpleprojekt.model.Person;
import org.springframework.data.domain.Page;

import java.util.List;

public class  GraphQLPaginationResult {

    private GraphQLPaginationPageInfo pageInfo;
    private List<Person> result;

    public GraphQLPaginationResult(Page<Person> result){
        this.result = result.getContent();
        this.pageInfo = new GraphQLPaginationPageInfo(result);
    }

    public GraphQLPaginationPageInfo getPageInfo() {
        return pageInfo;
    }

    public List<Person> getResult() {
        return result;
    }

}
