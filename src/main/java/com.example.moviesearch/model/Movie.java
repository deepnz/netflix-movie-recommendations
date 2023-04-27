package com.example.moviesearch.model

        public class Movie {
    private String id;
    private String title;
    private String description;
    private List<String> associations;
    private List<String> tags;
    public Movie(String id, String title, String description,List<String> associations, List<String> tags){
        this.id = id;
        this.title = title;
        this.description = description;
        this.associations = associations;
        this.tags = tags;
    }
        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public List<String> getAssociations() {
            return associations;
        }

        public void setAssociations(List<String> associations) {
            this.associations = associations;
        }

        public List<String> getTags() {
            return tags;
        }

        public void setTags(List<String> tags) {
            this.tags = tags;
        }
    }