package com.example.gabekeyner.successquote;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by GabeKeyner on 11/6/2016.
 */

public class QuotePost implements Parcelable {


    public static final Creator<QuotePost> CREATOR = new Creator<QuotePost>() {
        @Override
        public QuotePost createFromParcel(Parcel in) {
            return new QuotePost(in);
        }

        @Override
        public QuotePost[] newArray(int size) {
            return new QuotePost[size];
        }
    };
    private String authorName;
    private String quoteBody;
    private String authorCategory;
    private Boolean mChecked;

    public QuotePost(String name, String body, String category) {
        authorName = name;
        quoteBody = body;
        authorCategory = category;
    }

    protected QuotePost(Parcel in) {
        authorName = in.readString();
        quoteBody = in.readString();
        authorCategory = in.readString();
        mChecked = in.readByte() !=0;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(authorName);
        parcel.writeString(quoteBody);
        parcel.writeString(authorCategory);
        parcel.writeByte((byte) (mChecked ? 1:0));
    }
}
