package com.example.gift;

public class detail {

    private String name, fam, city, present;
    private int id;

    public detail(String name, String fam, String city, String present, int id) {
        this.setName(name);
        this.setId(id);
        this.setFam(fam);
        this.setCity(city);
        this.setPresent(present);
    }

    public String getPresent() {
        return present;
    }

    public void setPresent(String present) {
        this.present = present;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getFam() {
        return fam;
    }

    public void setFam(String fam) {
        this.fam = fam;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
