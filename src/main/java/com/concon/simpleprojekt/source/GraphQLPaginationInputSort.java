package com.concon.simpleprojekt.source;

public class GraphQLPaginationInputSort {
    public static enum SortDirection {
        ASCENDING,DESCENDING
    }

    private String fieldName;
    private SortDirection sortDirection;

    public SortDirection getSortDirection() {
        return sortDirection;
    }

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public void setSortDirection(SortDirection sortDirection) {
        this.sortDirection = sortDirection;
    }
}
