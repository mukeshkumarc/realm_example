package com.example.mukesh_kumar.realm.ViewModels;

import java.util.Date;

import io.realm.RealmObject;

/**
 * Created by mukesh_kumar on 22/10/15.
 */
public class ClassReviewVM extends RealmObject {

    private Date date;
    private	String	Review;
    private	int	Rating_Score;
    private	ClassSummaryVM	classSummary;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getReview() {
        return Review;
    }

    public void setReview(String review) {
        Review = review;
    }

    public int getRating_Score() {
        return Rating_Score;
    }

    public void setRating_Score(int rating_Score) {
        Rating_Score = rating_Score;
    }

    public ClassSummaryVM getClassSummary() {
        return classSummary;
    }

    public void setClassSummary(ClassSummaryVM classSummary) {
        this.classSummary = classSummary;
    }
}
