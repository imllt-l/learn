package com.example.imllt.learn;

public class NanChang {
    private int Id ;
    private String Name;
    NanChang(String name,int id){
        this.Id = id;
        this.Name = name;
    }
    public String getName(){
        return  Name;
    }
    public int getId(){
        return  Id;
    }

}
