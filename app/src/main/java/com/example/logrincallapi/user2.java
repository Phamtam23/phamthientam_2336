package com.example.logrincallapi;

import java.io.Serializable;

public class user2 implements Serializable {
    private String anh;
    private String ten;
    private String gt;

    public String getAnh() {
        return anh;
    }

    public void setAnh(String anh) {
        this.anh = anh;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getGt() {
        return gt;
    }

    public void setGt(String gt) {
        this.gt = gt;
    }

    public user2(String anh, String gt, String ten) {
        this.anh = anh;
        this.gt = gt;
        this.ten = ten;
    }

    public user2() {
    }

    @Override
    public String toString() {
        return "user2{" +
                "anh='" + anh + '\'' +
                ", ten='" + ten + '\'' +
                ", gt='" + gt + '\'' +
                '}';
    }
}
