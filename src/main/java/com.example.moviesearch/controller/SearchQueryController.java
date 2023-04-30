// SearchQueryController.java
package com.example.moviesearch.controller;

import com.example.moviesearch.model.SearchQuery;
import com.example.moviesearch.service.SearchQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/search-queries")
public class SearchQueryController {
    @Autowired
    private SearchQueryService searchQueryService;

    @GetMapping("/{id}")
    public ResponseEntity<SearchQuery> getSearchQueryById(@PathVariable String id) {
        SearchQuery searchQuery = searchQueryService.getSearchQueryById(id);
        return new ResponseEntity<>(searchQuery, HttpStatus.OK);
    }

    @GetMapping("/")
    public ResponseEntity<List<SearchQuery>> getAllSearchQueries() {
        List<SearchQuery> searchQueries = searchQueryService.getAllSearchQueries();
        return new ResponseEntity<>(searchQueries, HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<SearchQuery> addSearchQuery(@RequestBody SearchQuery searchQuery) {
        SearchQuery newSearchQuery = searchQueryService.addSearchQuery(searchQuery);
        return new ResponseEntity<>(newSearchQuery, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<SearchQuery> updateSearchQuery(@PathVariable String id, @RequestBody SearchQuery searchQuery) {
        SearchQuery updatedSearchQuery = searchQueryService.updateSearchQuery(id, searchQuery);
        return new ResponseEntity<>(updatedSearchQuery, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSearchQuery(@PathVariable String id) {
        searchQueryService.deleteSearchQuery(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
