package com.example.imllt.learn;

public class NanChang {
    private int Id ;
    private String Name;
    private String Text;
    NanChang(String name,int id,String text){
        this.Id = id;
        this.Name = name;
        this.Text = text;
    }
    public String getName(){
        return  Name;
    }
    public int getId(){
        return  Id;
    }
    public  String getdText(){
        return Text;
    }
}
