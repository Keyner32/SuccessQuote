package com.example.gabekeyner.successquote;

/**
 * Created by GabeKeyner on 11/2/2016.
 */

public class QuoteHelper {

    String author;

    String author_picture;

    String quote_category;

    String quote_body;



    public String getAuthor() {

        return author;
    }

    public String getQuote_body() {
        return quote_body;
    }

    public void setQuote_body(String quote_body) {
        this.quote_body = quote_body;
    }

    public String getQuote_category() {
        return quote_category;
    }

    public String getAuthor_picture() {
        return author_picture;
    }

    public void setAuthor_picture(String author_picture) {
        this.author_picture = author_picture;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setQuote_category(String quote_category) {
        this.quote_category = quote_category;
    }

}
