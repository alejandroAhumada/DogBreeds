package com.alejandro.dogbreeds.domain;

import java.util.ArrayList;

public class Breeds {

    private String status;
    ArrayList<String> message = new ArrayList <String> ();

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public ArrayList<String> getMessage() {
        return message;
    }

    public void setMessage(ArrayList<String> message) {
        this.message = message;
    }
}
