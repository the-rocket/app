package com.daniyar.app;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by alashov on 28/04/16.
 */
public class Photo implements Parcelable {
    private Uri uri;
    private String title;

    public Photo() {
    }

    public Uri getUri() {
        return uri;
    }

    public Photo setUri(Uri uri) {
        this.uri = uri;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public Photo setTitle(String title) {
        this.title = title;
        return this;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeParcelable(this.uri, flags);
        dest.writeString(this.title);
    }

    protected Photo(Parcel in) {
        this.uri = in.readParcelable(Uri.class.getClassLoader());
        this.title = in.readString();
    }

    public static final Creator<Photo> CREATOR = new Creator<Photo>() {
        @Override
        public Photo createFromParcel(Parcel source) {
            return new Photo(source);
        }

        @Override
        public Photo[] newArray(int size) {
            return new Photo[size];
        }
    };
}
