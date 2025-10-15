package com.example.listycity;

/**
 * This is a class that defines a City.
 */
public class City implements Comparable {
    private String city;
    private String province;
    City(String city, String province){
        this.city = city;
        this.province = province;
    }
    String getCityName(){
        return this.city;
    }
    String getProvinceName(){
        return this.province;
    }

    /** This method compares cities based on city name field
     * @return -1 if the caller is greater than the city name field
     */
    @Override
    public int compareTo(Object o) {
        City city = (City) o;  // typecasting
        return this.city.compareTo(city.getCityName());
    }
}
