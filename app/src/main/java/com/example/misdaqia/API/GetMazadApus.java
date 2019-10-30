
package com.example.misdaqia.API;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class GetMazadApus {

    @SerializedName("id")
    @Expose
    private int id;
    @SerializedName("created_at")
    @Expose
    private String createdAt;
    @SerializedName("updated_at")
    @Expose
    private String updatedAt;
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("vendor")
    @Expose
    private String vendor;
    @SerializedName("color")
    @Expose
    private String color;
    @SerializedName("year")
    @Expose
    private String year;
    @SerializedName("new")
    @Expose
    private String _new;
    @SerializedName("model")
    @Expose
    private String model;
    @SerializedName("price")
    @Expose
    private int price;
    @SerializedName("ownerID")
    @Expose
    private int ownerID;
    @SerializedName("Auction_type")
    @Expose
    private String auctionType;
    @SerializedName("location")
    @Expose
    private String location;
    @SerializedName("Guarant")
    @Expose
    private int guarant;
    @SerializedName("viewers")
    @Expose
    private int viewers;
    @SerializedName("image")
    @Expose
    private String image;
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("producttime")
    @Expose
    private Object producttime;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getVendor() {
        return vendor;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getNew() {
        return _new;
    }

    public void setNew(String _new) {
        this._new = _new;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
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

    public String getAuctionType() {
        return auctionType;
    }

    public void setAuctionType(String auctionType) {
        this.auctionType = auctionType;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getGuarant() {
        return guarant;
    }

    public void setGuarant(int guarant) {
        this.guarant = guarant;
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

    public Object getProducttime() {
        return producttime;
    }

    public void setProducttime(Object producttime) {
        this.producttime = producttime;
    }

}
