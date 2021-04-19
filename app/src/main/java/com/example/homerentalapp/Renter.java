package com.example.homerentalapp;

public class Renter {

    private String rentername;
    private String flatname;
    private String contactnumber;
    private int renterid;

    public Renter(String rentername, String flatname, String contactnumber, int renterid) {
        this.rentername = rentername;
        this.flatname = flatname;
        this.contactnumber = contactnumber;
        this.renterid = renterid;
    }
    public Renter() {
    }
    public Renter(String rentername, String flatname, String contactnumber) {
        this.rentername = rentername;
        this.flatname = flatname;
        this.contactnumber = contactnumber;
    }

    public String getRentername() {
        return rentername;
    }

    public void setRentername(String rentername) {
        this.rentername = rentername;
    }

    public String getFlatname() {
        return flatname;
    }

    public void setFlatname(String flatname) {
        this.flatname = flatname;
    }

    public String getContactnumber() {
        return contactnumber;
    }

    public void setContactnumber(String contactnumber) {
        this.contactnumber = contactnumber;
    }

    public int getRenterid() {
        return renterid;
    }

    public void setRenterid(int renteridid) {
        this.renterid = renterid;
    }
}
