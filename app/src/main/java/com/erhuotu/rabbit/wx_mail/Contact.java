package com.erhuotu.rabbit.wx_mail;

import java.io.Serializable;

public class Contact implements Serializable {
    private String mName;
    private int mType;

    public Contact(String name, int type) {
        mName = name;
        mType = type;
    }

    public String getmName() {
        return mName;
    }

    public int getmType() {
        return mType;
    }

}
