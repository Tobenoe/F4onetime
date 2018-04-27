package com.example.zs.onetime.bean;

/**
 * Created by work on 2018/4/27.
 */

public class SildeBean {

      private String text;
      private int leftImg;
      private int right;

    public SildeBean(String text, int leftImg, int right) {
        this.text = text;
        this.leftImg = leftImg;
        this.right = right;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getLeftImg() {
        return leftImg;
    }

    public void setLeftImg(int leftImg) {
        this.leftImg = leftImg;
    }

    public int getRight() {
        return right;
    }

    public void setRight(int right) {
        this.right = right;
    }
}
