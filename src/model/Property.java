/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Ray
 */
public class Property {
    private int propertyID;
    private String address;
    private String type;
    private double price;
    private int yearBuilt;

    // Constructor to initialize the property [cite: 49]
    public Property(int propertyID, String address, String type, double price, int yearBuilt) {
        this.propertyID = propertyID;
        this.address = address;
        this.type = type;
        this.price = price;
        this.yearBuilt = yearBuilt;
    }

    // Getters are required for the JTable and Search algorithms [cite: 18, 81]
    public int getPropertyID() { return propertyID; }
    public String getAddress() { return address; }
    public String getType() { return type; }
    public double getPrice() { return price; }
    public int getYearBuilt() { return yearBuilt; }
    
}
