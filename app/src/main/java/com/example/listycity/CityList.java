package com.example.listycity;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * This is a class that keeps a list of city objects
 */
public class CityList {
    private List<City> cities = new ArrayList<>();

    /**
     * This adds a city to the list if the city does not exist
     * @param city: This is a candidate city to add
     */
    public void add(City city) {
        if (cities.contains(city)) {
            throw new IllegalArgumentException();
        }
        cities.add(city);
    }

    /**
     * This returns a sorted list of cities
     * @return
     * Return the sorted list
     */
    public List<City> getCities() {
        List<City> list = cities;
        Collections.sort(list);
        return list;
    }

    /**
     * Checks if the city is in the list
     * @param city
     * @return
     * Returns a boolean
     */
    public boolean hasCity(City city) {
        return this.cities.contains(city);
    }

    /**
     * Deletes a city from the list. If not in the list, throws an exception.
     * @param city
     */
    public void delete(City city) {
        if (this.hasCity(city)) {
            this.cities.remove(city);
        } else {
            throw new IllegalArgumentException();
        }
    }

    /**
     * Returns the total number of cities.
     * @return
     */
    public int countCities() {
        return this.cities.size();
    }
}
