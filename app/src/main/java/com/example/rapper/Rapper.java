//import statements
package com.example.rapper;

//A class that will store data from the JSON file containing the artists
public class Rapper {
    //Variables
    int id;
    String name;
    String description;
    String url;


    //methods
    //set Methods
    public void setId(int newID) {
        id = newID;
    }

    public void setName(String newName) {
        name = newName;
    }

    public void setDescription(String newDesc) {
        description = newDesc;
    }

    public void setUrl(String newURL) {
        url = newURL;
    }

    //get Methods
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getURL() {
        return url;
    }

    //constructor method
    public Rapper(int ids, String names, String descriptions, String urls) {
        this.setId(ids);
        this.setName(names);
        this.setDescription(descriptions);
        this.setUrl(urls);
    }
}
