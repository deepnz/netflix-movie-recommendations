package com.example.moviesearch.model

public class User{
private String name;
private String email;

private List<String> movieLiked;
private List<String> watchList;
private List<String> moviesSeen;
private List<String> moviesDisliked;

    public User(String name, String email, List<String> movieLiked, List<String> watchList, List<String> moviesSeen, List<String> moviesDisliked) {
        this.name = name;
        this.email = email;
        this.movieLiked = movieLiked;
        this.watchList = watchList;
        this.moviesSeen = moviesSeen;
        this.moviesDisliked = moviesDisliked;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<String> getMovieLiked() {
        return movieLiked;
    }

    public void setMovieLiked(List<String> movieLiked) {
        this.movieLiked = movieLiked;
    }

    public List<String> getWatchList() {
        return watchList;
    }

    public void setWatchList(List<String> watchList) {
        this.watchList = watchList;
    }

    public List<String> getMoviesSeen() {
        return moviesSeen;
    }

    public void setMoviesSeen(List<String> moviesSeen) {
        this.moviesSeen = moviesSeen;
    }

    public List<String> getMoviesDisliked() {
        return moviesDisliked;
    }

    public void setMoviesDisliked(List<String> moviesDisliked) {
        this.moviesDisliked = moviesDisliked;
    }
}