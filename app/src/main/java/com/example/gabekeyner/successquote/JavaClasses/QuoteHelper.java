package com.example.gabekeyner.successquote.JavaClasses;

/**
 * Created by GabeKeyner on 11/2/2016.
 */
//This class is used as a model for a Quote
public class QuoteHelper {

    String author;

    String author_picture;

    String quote_category;

    String quote_body;

    String quote_link;


    public QuoteHelper() {

    }

    public QuoteHelper(String author, String author_picture, String quote_category, String quote_body) {
        this.author = author;
        this.author_picture = author_picture;
        this.quote_category = quote_category;
        this.quote_body = quote_body;
    }


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

    public String getQuote_link() {
        return quote_link;
    }

    public void setQuote_link(String quote_link) {
        this.quote_link = quote_link;
    }
}
