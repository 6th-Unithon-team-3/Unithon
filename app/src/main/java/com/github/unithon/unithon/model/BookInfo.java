package com.github.unithon.unithon.model;

public class BookInfo {
    private String title;
    private String author;
    private String imgUrl;

    private int reviews;
    private int likes;
    private int hates;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public int getReviews() {
        return reviews;
    }

    public void setReviews(int reviews) {
        this.reviews = reviews;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public int getHates() {
        return hates;
    }

    public void setHates(int hates) {
        this.hates = hates;
    }

    public static BookInfo getDummyBookInfo() {
        final BookInfo bookInfo = new BookInfo();

        bookInfo.title = "title";
        bookInfo.author = "author";
        bookInfo.imgUrl = "http://bookthumb.phinf.naver.net/cover/109/245/10924505.jpg?type=m1&udate=20171007";

        bookInfo.reviews = 35;
        bookInfo.likes = 10;
        bookInfo.hates = 25;

        return bookInfo;
    }

}
