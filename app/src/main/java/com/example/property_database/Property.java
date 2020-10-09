package com.example.property_database;

public class Property {
private  String name;

    public String getProperty_type() {
        return property_type;
    }

    public void setProperty_type(String property_type) {
        this.property_type = property_type;
    }

    private  String property_type;


    public String getSpd() {
        return spd;
    }

    public void setSpd(String spd) {
        this.spd = spd;
    }

    private String spd;

    public String getDimension() {
        return dimension;
    }

    public void setDimension(String dimension) {
        this.dimension = dimension;
    }

    public String getSqrd() {
        return sqrd;
    }

    public void setSqrd(String sqrd) {
        this.sqrd = sqrd;
    }

    public String getOnsites() {
        return onsites;
    }

    public void setOnsites(String onsites) {
        this.onsites = onsites;
    }

    public String getCarpets() {
        return carpets;
    }

    public void setCarpets(String carpets) {
        this.carpets = carpets;
    }

    public String getSuperareas() {
        return superareas;
    }

    public void setSuperareas(String superareas) {
        this.superareas = superareas;
    }

    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getFinalcost() {
        return finalcost;
    }

    public void setFinalcost(String finalcost) {
        this.finalcost = finalcost;
    }

    public String getOther() {
        return other;
    }

    public void setOther(String other) {
        this.other = other;
    }

    private String dimension;
    private String sqrd;
    private String onsites;
    private String carpets;
    private String superareas;
    private String cost;
    private String start;
    private String finalcost;
    private String other;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    private String id;

    @Override
    public String toString() {
        return "Property{" +
                "name='" + name + '\'' +
                ", location='" + location + '\'' +
                '}';
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    private String  location;

    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }

    public Property(){

}
}
