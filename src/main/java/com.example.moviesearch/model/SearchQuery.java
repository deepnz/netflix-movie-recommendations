package com.example.moviesearch.model;

public class SearchQuery {
    private List<String> query;
    public SearchQuery() {
    }
    public SearchQuery(List<String> query) {
        this.query = query;
    }

    public List<String> getQuery() {
        return query;
    }

    public void setQuery(List<String> query) {
        this.query = query;
    }
}
