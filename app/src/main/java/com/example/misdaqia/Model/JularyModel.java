package com.example.misdaqia.Model;

import com.google.gson.annotations.SerializedName;

public class JularyModel {
    @SerializedName("id")
    public  int id;
    @SerializedName("created_at")
    public  String created_at;
    @SerializedName("updated_at")
    public  String updated_at;
    @SerializedName("type")
    public  String type;
    @SerializedName("material")
    public  String material;

    @SerializedName("area")
    public  String area;
    @SerializedName("street")
    public  String street;
    @SerializedName("city")
    public  String city;
    @SerializedName("rental")
    public  String rental;
    @SerializedName("floors")
    public  int floors;
    @SerializedName("furnished")
    public  String furnished;
    @SerializedName("rooms")
    public  int rooms;
    @SerializedName("SizeInMeter")
    public  int SizeInMeter;
    @SerializedName("gender")
    public  String gender;
    @SerializedName("weight")
    public  int weight;
    @SerializedName("price")
    public  int price;
    @SerializedName("ownerID")
    public  int ownerID;
    @SerializedName("year")
    public  int year;
    @SerializedName("new")
    public  String New;
    @SerializedName("color")
    public  String color;
    @SerializedName("model")
    public  String model;
    @SerializedName("Auction_type")
    public  String Auction_type;
    @SerializedName("location")
    public  String location;
    @SerializedName("Guarant")
    public  int Guarant;
    @SerializedName("viewers")
    public  int viewers;
    @SerializedName("image")
    public  String image;
    @SerializedName("status")
    public  String status;
    @SerializedName("producttime")
    public  String producttime;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(String updated_at) {
        this.updated_at = updated_at;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getOwnerID() {
        return ownerID;
    }

    public void setOwnerID(int ownerID) {
        this.ownerID = ownerID;
    }

    public String getNew() {
        return New;
    }

    public void setNew(String aNew) {
        New = aNew;
    }

    public String getAuction_type() {
        return Auction_type;
    }

    public void setAuction_type(String auction_type) {
        Auction_type = auction_type;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getGuarant() {
        return Guarant;
    }

    public void setGuarant(int guarant) {
        Guarant = guarant;
    }

    public int getViewers() {
        return viewers;
    }

    public void setViewers(int viewers) {
        this.viewers = viewers;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getProducttime() {
        return producttime;
    }

    public void setProducttime(String producttime) {
        this.producttime = producttime;
    }
}
