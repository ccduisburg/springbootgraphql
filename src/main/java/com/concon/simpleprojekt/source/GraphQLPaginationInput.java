package com.concon.simpleprojekt.source;

import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
public class GraphQLPaginationInput {
    private Integer offsetPage;
    private Integer pageSize;

    public GraphQLPaginationInput(Integer offsetPage, Integer pageSize) {
        this.offsetPage = offsetPage;
        this.pageSize = pageSize;
    }

    private List<GraphQLPaginationInputSort> sorts;

    public List<GraphQLPaginationInputSort> getSorts() {
        if (sorts == null){
            sorts = new ArrayList<>();
        }
        return sorts;
    }

    public void setSorts(List<GraphQLPaginationInputSort> sorts) {
        this.sorts = sorts;
    }

    public Integer getOffsetPage()
    {
        if (offsetPage == null){
            offsetPage = 1;
        }
        return offsetPage;
    }

    public Integer getPageSize() {
        if (pageSize == null){
            pageSize = 1;
        }
        return pageSize;
    }

    public void setOffsetPage(Integer offsetPage) {
        this.offsetPage = offsetPage;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }


}