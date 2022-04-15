package com.example.databasetest;


public class book {
    private int id;
    private String author;
    private int price;
    private int pages;
    private String name;
    private String category_id;

    public int getId(){return id;}
    public void setId(){this.id=id;}
    public String getAuthor() {
        return author;
    }
    public void setAuthor(String author) {
        this.author = author;
    }
    public int getPrice(){ return price; }
    public void setPrice(int price) { this.price = price; }
    public int getPages(){return pages;}
    public void setPages(int pages){this.pages=pages;}
    public String getName(){return name;}
    public void setName(String name){this.name=name;}
    public String getCategory_id(){return category_id; }
    public void setCategory_id(){this.category_id=category_id;}


    @Override
    public String toString() {
        return id + ", "+ author + ","+ price +","+ pages +"," +name+ ","+ category_id;
    }
    public book(String author, String name) {
        super();
        this.id = id;
        this.author=author;
        this.price=price;
        this.pages=pages;
        this.name=name;
        this.category_id=category_id;
    }


}