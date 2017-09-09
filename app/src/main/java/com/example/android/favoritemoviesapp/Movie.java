package com.example.android.favoritemoviesapp;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Represents a Movie which contains a Title, Release Date, a reference to a poster, a vote average and a plot.
 */

public class Movie implements Parcelable {

    private String movieTitle;
    private String movieReleaseDate;
    private String moviePosterPath;
    private double movieVoteAverage;
    private String moviePlot;

//    Constructors

    public Movie(String movieTitle, String movieReleaseDate, String moviePoster, double movieVoteAverage, String moviePlot) {
        this.movieTitle = movieTitle;
        this.movieReleaseDate = movieReleaseDate;
        this.moviePosterPath = moviePoster;
        this.movieVoteAverage = movieVoteAverage;
        this.moviePlot = moviePlot;
    }

    private Movie(Parcel in) {
        movieTitle = in.readString();
        movieReleaseDate = in.readString();
        moviePosterPath = in.readString();
        movieVoteAverage = in.readDouble();
        moviePlot = in.readString();
    }

//    Getters

    public String getMovieTitle() {
        return this.movieTitle;
    }

    public String getMovieReleaseDate() {
        return this.movieReleaseDate;
    }

    public String getMoviePosterPath() {
        return this.moviePosterPath;
    }

    public double getMovieVoteAverage() {
        return this.movieVoteAverage;
    }

    public String getMoviePlot() {
        return this.moviePlot;
    }

//    Setters

    public void setMovieTitle(String title) {
        this.movieTitle = title;
    }

    public void setMovieReleaseDate(String releaseDate) {
        this.movieReleaseDate = releaseDate;
    }

    public void setMoviePosterPath(int posterId) {
        this.moviePosterPath = moviePosterPath;
    }

    public void setMovieVoteAverage(double voteAverage) {
        this.movieVoteAverage = voteAverage;
    }

    public void setMoviePlot(String plot) {
        this.moviePlot = plot;
    }


//    Implementing Parcelable


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(movieTitle);
        parcel.writeString(movieReleaseDate);
        parcel.writeString(moviePosterPath);
        parcel.writeDouble(movieVoteAverage);
        parcel.writeString(moviePlot);
    }

    public final Parcelable.Creator<Movie> CREATOR = new Parcelable.Creator<Movie>() {

        @Override
        public Movie createFromParcel(Parcel parcel) {
            return new Movie(parcel);
        }

        @Override
        public Movie[] newArray(int i) {
            return new Movie[i];
        }
    };
}
