package com.mttask.model;

/**
 * Created by abhimanyus on 2/1/18.
 */
public class BookDetails {

    private String id;
    private String name;
    private String author;
    private String yearOfPublication;
    private String press;
    private String image1;
    private String image2;
    private String image3;

    public BookDetails(String id, String name, String author, String yearOfPublication, String press, String image1, String image2, String image3) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.yearOfPublication = yearOfPublication;
        this.press = press;
        this.image1 = image1;
        this.image2 = image2;
        this.image3 = image3;
    }


    public BookDetails() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getYearOfPublication() {
        return yearOfPublication;
    }

    public void setYearOfPublication(String yearOfPublication) {
        this.yearOfPublication = yearOfPublication;
    }

    public String getPress() {
        return press;
    }

    public void setPress(String press) {
        this.press = press;
    }

    public String getImage1() {
        return image1;
    }

    public void setImage1(String image1) {
        this.image1 = image1;
    }

    public String getImage2() {
        return image2;
    }

    public void setImage2(String image2) {
        this.image2 = image2;
    }

    public String getImage3() {
        return image3;
    }

    public void setImage3(String image3) {
        this.image3 = image3;
    }


    @Override
    public String toString() {
        return "ID :" +this.getId() + " name : " + this.name + " author : " +this.author + " year : " +this.yearOfPublication
                + " press : " +this.press + " image1 url : " +this.image1 + " image2 url :" +this.image2 + " image3 url :" +this.image3;
    }
}

