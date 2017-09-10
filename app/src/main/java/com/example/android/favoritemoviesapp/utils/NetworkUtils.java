package com.example.android.favoritemoviesapp.utils;

import android.net.Uri;
import android.util.Log;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

/**
 * Utilities that will be used to connect to the network
 */

public class NetworkUtils {

    final static String MOVIEDB_URL = "https://api.themoviedb.org/3/movie/";

    // Parameters to build the URL
    final static String PARAM_QUERY = "q";

    final static String PARAM_KEY = "api_key";
//    final static String API_KEY; // TODO: add MoviesDB API key

    private String finalBaseUrl;

    /**
     * Build the URL used to query MovieDB
     *
     * @param sortBy The user's preference of movies to display
     * @return The URL to fetch movies according to user's preferences
     */
    public static URL buildURL(String sortBy) {

        URL url = null;

        String criteria = null;

        Log.v("NetworkUtils", sortBy);

        if (sortBy == "Most Popular") {
            criteria = "popular";
        } else if (sortBy == "Top Rated") {
            criteria = "top_rated";
        } else {
            criteria = "popular";
        }

        if (criteria != null) {

            Uri buildUri = Uri.parse(MOVIEDB_URL + criteria).buildUpon()
                    .appendQueryParameter(PARAM_KEY, API_KEY)
                    .build();
            try {
                url = new URL(buildUri.toString());
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        }

        return url;
    }

    public static String getResponseFromHttpUrl(URL url) throws IOException {
        HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
        try {
            InputStream in = urlConnection.getInputStream();
            Scanner scanner = new Scanner(in);
            scanner.useDelimiter("\\A");

            boolean hasInput = scanner.hasNext();
            if (hasInput) {
                return scanner.next();
            } else {
                return null;
            }
        } finally {
            urlConnection.disconnect();
        }
    }
}
