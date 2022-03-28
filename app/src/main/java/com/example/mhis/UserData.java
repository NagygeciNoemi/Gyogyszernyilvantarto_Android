package com.example.mhis;

import java.util.Date;

public class UserData
{
    private int taj;
    private String username;
    private String p_name;
    private String p_address;
    private String p_birthday;
    private String p_birthplace;
    private String p_password;
    private String allergy;
    private String p_email;

    public UserData(int taj, String username, String p_name, String p_address, String p_birthday, String p_birthplace, String p_password, String allergy, String p_email) {
        this.taj = taj;
        this.username = username;
        this.p_name = p_name;
        this.p_address = p_address;
        this.p_birthday = p_birthday;
        this.p_birthplace = p_birthplace;
        this.p_password = p_password;
        this.allergy = allergy;
        this.p_email = p_email;
    }


    public int getTaj() {
        return taj;
    }

    public String getUsername() {
        return username;
    }

    public String getP_name() {
        return p_name;
    }

    public String getP_address() {
        return p_address;
    }

    public String getP_birthday() {
        return p_birthday;
    }

    public String getP_birthplace() {
        return p_birthplace;
    }

    public String getP_password() {
        return p_password;
    }

    public String getAllergy() {
        return allergy;
    }

    public String getP_email() {
        return p_email;
    }
}
