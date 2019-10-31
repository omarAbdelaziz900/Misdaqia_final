package com.example.misdaqia.Model;


import android.support.annotation.DrawableRes;

public class NavigationDrawerItem {
    public int icon;
    public String name;

    public static final int HEADER_VIEW_TYPE = 1;
    public static final int MENU_TYPE = 2;
    public static final int FOOTER_VIEW_TYPE = 3;
    private int mType;
    private String title;
    @DrawableRes
    private Integer image;

    // Constructor.
    public NavigationDrawerItem() {
    }

    public NavigationDrawerItem(int type) {
        this.mType = type;
    }

    public NavigationDrawerItem(String name, @DrawableRes Integer image, int type) {
        this.title = name;
        this.mType = type;
        this.image = image;
    }

    public NavigationDrawerItem(@DrawableRes Integer image,String name) {
        this.image = image;
        this.title = name;
        this.mType = MENU_TYPE;
    }

    public int getType() {
        return mType;
    }

    public void setType(int type) {
        this.mType = type;
    }


    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static int getHeaderViewType() {
        return HEADER_VIEW_TYPE;
    }

    public static int getMenuType() {
        return MENU_TYPE;
    }

    public static int getFooterViewType() {
        return FOOTER_VIEW_TYPE;
    }

    public int getmType() {
        return mType;
    }

    public void setmType(int mType) {
        this.mType = mType;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getImage() {
        return image;
    }

    public void setImage(Integer image) {
        this.image = image;
    }
}
