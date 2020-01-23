package com.concon.simpleprojekt.source;


import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class GraphQLPaginationPageableFactory {


    public static Pageable toPageable(GraphQLPaginationInput graphQLPaginationInput){

        if (graphQLPaginationInput == null){
            return  PageRequest.of(1,20);
        }
        else {
            Predicate<GraphQLPaginationInputSort> filter = graphQLPaginationInputSort -> graphQLPaginationInputSort.getSortDirection() != null;
            if (graphQLPaginationInput.getSorts().stream().filter(filter).count() > 0){
                List<Sort.Order> orders = graphQLPaginationInput.getSorts().stream().filter(filter).map(graphQLPaginationInputSort -> {
                    Sort.Direction direction = Sort.Direction.ASC;
                    if (graphQLPaginationInputSort.getSortDirection() == GraphQLPaginationInputSort.SortDirection.DESCENDING){
                        direction = Sort.Direction.DESC;
                    }
                    return new Sort.Order(direction,graphQLPaginationInputSort.getFieldName());
                }).collect(Collectors.toList());
                Sort sort = Sort.by(orders);
                return PageRequest.of(graphQLPaginationInput.getOffsetPage(),graphQLPaginationInput.getPageSize(),sort);
            }
            return  PageRequest.of(graphQLPaginationInput.getOffsetPage(),graphQLPaginationInput.getPageSize());
        }

    }

}
