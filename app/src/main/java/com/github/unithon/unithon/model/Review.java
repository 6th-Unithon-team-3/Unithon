package com.github.unithon.unithon.model;

import java.util.ArrayList;
import java.util.List;

public class Review {

    private String isbn;
    private String id;
    private String title;
    private String review;
    private boolean isLike;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    public boolean isLike() {
        return isLike;
    }

    public void setLike(boolean like) {
        isLike = like;
    }

    public static List<Review> getDummyReviewList() {
        final List<Review> reviewList = new ArrayList<>();

        for(int i = 0; i < 10; i++) {
            final Review review = new Review();
            review.id = "@_ojh10" + i;
            review.review =
                    i + "번째 리뷰 " + i + "번째 리뷰 " + i + "번째 리뷰 " + i + "번째 리뷰 " + i + "번째 리뷰 " + i + "번째 리뷰 " + i + "번째 리뷰 " + i
                            + "번째 리뷰 " + i + "번째 리뷰 " + i + "번째 리뷰 ";
            review.isLike = i % 2 == 0;

            reviewList.add(review);
        }

        return reviewList;
    }
}
