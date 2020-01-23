package com.concon.simpleprojekt.source;

import org.springframework.data.domain.Page;


public class GraphQLPaginationPageInfo {

    private Long totalElements;
    private Integer totalPages;
    private Integer number;
    private Integer size;

    public GraphQLPaginationPageInfo(Page page){
        this.totalElements = page.getTotalElements();
        this.totalPages = page.getTotalPages();
        this.number = page.getNumber();
        this.size = page.getSize();
    }

    public Integer getNumber() {
        return number;
    }

    public Integer getSize() {
        return size;
    }

    public Long getTotalElements() {
        return totalElements;
    }

    public Integer getTotalPages() {
        return totalPages;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public void setTotalElements(Long totalElements) {
        this.totalElements = totalElements;
    }

    public void setTotalPages(Integer totalPages) {
        this.totalPages = totalPages;
    }
}
