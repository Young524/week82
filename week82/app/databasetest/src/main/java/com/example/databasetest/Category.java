package com.example.databasetest;

public class Category {
    private int id;
    private String categoryname;
    private int categorycode;

    public Category(Object categoryname) {
    }

    private int getId(){return id;}
    private void setId(int id){
        this.id=id;
    }
    public String getCategoryname(){
        return categoryname;
    }
    public void setCategoryname(String categoryname){
        this.categoryname=categoryname;
    }
    private int getCategorycode(){
        return categorycode;
    }
    public void setCategorycode(int categorycode){
        
        this.categorycode=categorycode;
    }
}
