package com.example.viewdemo;

public class Book {
    private String name;
    private int imageRes;//图片资源

    public Book(String name, int imageRes) {
        this.name = name;
        this.imageRes = imageRes;
    }

    @Override
    public String toString() {//重写toString方法，保证选择下拉提示列表中的某一项时返回书名
        return name;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getImageRes() {
        return imageRes;
    }
    public void setImageRes(int imageRes) {
        this.imageRes = imageRes;
    }


}
