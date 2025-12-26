/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;
import model.Property;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.List;

/**
 *
 * @author Ray
 */
public class PropertyController {
    private final List<Property> propertyList; // List for the Admin Dashboard [cite: 24]
    
    public PropertyController() {
        this.propertyList = new ArrayList<>();
      
        // Initialize your ArrayList and Queue here [cite: 24, 57]
    }
    
    public void addSampleData() {
    // Adding 5 sample properties to satisfy coursework requirements 
    addPropertyToSystem(new Property(101, "Kathmandu", "House",500000, 2015));
    addPropertyToSystem(new Property(102, "Pokhara", "Land", 5000000, 2020));
    addPropertyToSystem(new Property(103, "Lalitpur", "Apartment", 8500000, 2018));
    addPropertyToSystem(new Property(104, "Bhaktapur", "House", 120000, 2010));
    addPropertyToSystem(new Property(105, "Chitwan", "Land", 30000, 2022));
}
    public void sortByPrice(boolean ascending) {
    int n = propertyList.size();
    for (int i = 0; i < n - 1; i++) {
        int minOrMaxIdx = i;
        for (int j = i + 1; j < n; j++) {
            if (ascending) {
                // Ascending order logic
                if (propertyList.get(j).getPrice() < propertyList.get(minOrMaxIdx).getPrice()) {
                    minOrMaxIdx = j;
                }
            } else {
                // Descending order logic
                if (propertyList.get(j).getPrice() > propertyList.get(minOrMaxIdx).getPrice()) {
                    minOrMaxIdx = j;
                }
            }
        }
        // Swap the elements in the ArrayList
        Property temp = propertyList.get(minOrMaxIdx);
        propertyList.set(minOrMaxIdx, propertyList.get(i));
        propertyList.set(i, temp);
    }
}
    public Property binarySearchById(int searchId) {
    // Binary search requires the list to be sorted by ID first
    // You can call your sort method here or ensure it's sorted before searching
    int low = 0;
    int high = propertyList.size() - 1;

    while (low <= high) {
        int mid = (low + high) / 2;
        int midId = propertyList.get(mid).getPropertyID();

        if (midId == searchId) {
            return propertyList.get(mid); // Found it!
        } else if (midId < searchId) {
            low = mid + 1;
        } else {
            high = mid - 1;
        }
    }
    return null; // Not found
} 
    public boolean isIdDuplicate(int id) {
    for (Property p : propertyList) {
        if (p.getPropertyID() == id) {
            return true;
        }
    }
    return false;
    }
    public boolean updateProperty(int id, String address, String type, double price, int year) {
    for (Property p : propertyList) {
        if (p.getPropertyID() == id) {
            p.getAddress(); // Ensure your Property model has setAddress
            p.getType();       // Ensure your Property model has setType
            p.getPrice();     // Ensure your Property model has setPrice
            p.getYearBuilt();  // Check if your model uses 'setYear' or 'setYearBuilt'
            return true;
        }
    }
    return false;
}

// Helper method to update both the main list and the recent queue [cite: 55, 57]
private void addPropertyToSystem(Property p) {
    propertyList.add(p);
    
    // Manage the Queue to only keep the last 5 items [cite: 56]
    if (recentQueue.size() >= 5) {
        recentQueue.poll(); // Remove the oldest if more than 5
    }
    recentQueue.add(p);
}


public List<Property> getPropertyList() {
        return propertyList;
    }

    public void addProperty(Property property) {
    // Add to the main list for the Admin Dashboard
    // 1. Add to the main list [cite: 24]
    propertyList.add(property);
    
    // 2. Add to the Carousel Queue (Keep last 5) [cite: 56, 57]
    if (recentQueue.size() >= 5) {
        recentQueue.poll();
    }
    recentQueue.add(property);

}
    public boolean deleteProperty(int id) {
    // We use a lambda expression to find and remove the item with the matching ID
    // This effectively manages your data collection
    return propertyList.removeIf(property -> property.getPropertyID() == id);
}
    private final java.util.Queue<Property> recentQueue = new java.util.LinkedList<>();

public void addToRecent(Property property) {
    // Maintain exactly the last 5 items [cite: 56, 57]
    if (recentQueue.size() >= 5) {
        recentQueue.poll(); // Remove the oldest
    }
    recentQueue.add(property);
}

public java.util.List<Property> getRecentList() {
    return new java.util.ArrayList<>(recentQueue);
}
}
