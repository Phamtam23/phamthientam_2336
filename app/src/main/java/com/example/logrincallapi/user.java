package com.example.logrincallapi;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import java.io.Serializable;

public class user implements Serializable, Parcelable {
   private String idnguoidung;
   private String tennguoidung;
   private String email;
   private String passw;
   private String gioitinh;
   private String anhdaidien;
   private String ngaybatdau;
   private String ngayketthuc;

    protected user(Parcel in) {
        idnguoidung = in.readString();
        tennguoidung = in.readString();
        email = in.readString();
        passw = in.readString();
        gioitinh= in.readString();
        anhdaidien = in.readString();
        ngaybatdau = in.readString();
        ngayketthuc = in.readString();
    }

    public static final Creator<user> CREATOR = new Creator<user>() {
        @Override
        public user createFromParcel(Parcel in) {
            return new user(in);
        }

        @Override
        public user[] newArray(int size) {
            return new user[size];
        }
    };

    public user() {
    }

    public user(String idnguoidung, String tennguoidung, String email, String passw, String gioitinh, String anhdaidien, String ngaybatdau, String ngayketthuc) {
        this.idnguoidung = idnguoidung;
        this.tennguoidung = tennguoidung;
        this.email = email;
        this.passw = passw;
        this.gioitinh = gioitinh;
        this.anhdaidien = anhdaidien;
        this.ngaybatdau = ngaybatdau;
        this.ngayketthuc = ngayketthuc;
    }

    public String getTennguoidung() {
        return tennguoidung;
    }

    public void setTennguoidung(String tennguoidung) {
        this.tennguoidung = tennguoidung;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassw() {
        return passw;
    }

    public void setPassw(String passw) {
        this.passw = passw;
    }

    public String getGioitinh() {
        return gioitinh;
    }

    public void setGioitinh(String gioitinh) {
        this.gioitinh = gioitinh;
    }

    public String getAnhdaidien() {
        return anhdaidien;
    }

    public void setAnhdaidien(String anhdaidien) {
        this.anhdaidien = anhdaidien;
    }

    public String getNgaybatdau() {
        return ngaybatdau;
    }

    public void setNgaybatdau(String ngaybatdau) {
        this.ngaybatdau = ngaybatdau;
    }

    public String getNgayketthuc() {
        return ngayketthuc;
    }

    public void setNgayketthuc(String ngayketthuc) {
        this.ngayketthuc = ngayketthuc;
    }

    public String getIdnguoidung() {
        return idnguoidung;
    }

    public void setIdnguoidung(String idnguoidung) {
        this.idnguoidung = idnguoidung;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        parcel.writeString(idnguoidung);
        parcel.writeString(tennguoidung);
        parcel.writeString(email);
        parcel.writeString(passw);
        parcel.writeString(gioitinh);
        parcel.writeString(anhdaidien);
        parcel.writeString(ngaybatdau);
        parcel.writeString(ngayketthuc);
    }
}
