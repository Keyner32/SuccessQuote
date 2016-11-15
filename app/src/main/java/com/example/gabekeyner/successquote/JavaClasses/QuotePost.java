package com.example.gabekeyner.successquote.JavaClasses;

/**
 * Created by GabeKeyner on 11/6/2016.
 */

public class QuotePost extends QuoteHelper {


    String authorName;
    String quoteBody;
    String authorCategory;

    public QuotePost(String authorName, String quoteBody, String authorCategory) {
        this.authorName = authorName;
        this.quoteBody = quoteBody;
        this.authorCategory = authorCategory;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getAuthorCategory() {
        return authorCategory;
    }

    public void setAuthorCategory(String authorCategory) {
        this.authorCategory = authorCategory;
    }

    public String getQuoteBody() {
        return quoteBody;
    }

    public void setQuoteBody(String quoteBody) {
        this.quoteBody = quoteBody;
    }
}
