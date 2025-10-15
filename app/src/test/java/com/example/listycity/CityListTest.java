package com.example.listycity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;


public class CityListTest {
    private CityList mockCityList() {
        CityList cityList = new CityList();
        cityList.add(mockCity());
        return cityList;
    }

    private City mockCity() {
        return new City("Edmonton", "AB");
    }

    @Test
    public void testAdd() {
        CityList cityList = mockCityList();
        assertEquals(1, cityList.getCities().size());
        City city = new City("Regina", "SK");
        cityList.add(city);
        assertEquals(2, cityList.getCities().size());
        assertTrue(cityList.getCities().contains(city));
    }

    @Test
    public void testAddException() {
        CityList cityList = mockCityList();
        City c = new City("Yellowknife", "NW");
        cityList.add(c);
        assertThrows(IllegalArgumentException.class,()->{
            cityList.add(c);
        });
    }

    @Test
    public void testGetCities() {
        CityList cityList = mockCityList();
        assertEquals(0, mockCity().compareTo(cityList.getCities().get(0)));

        City city = new City("Charlottetown", "PE");
        cityList.add(city);

        assertEquals(0, city.compareTo(cityList.getCities().get(0)));
        assertEquals(0, mockCity().compareTo(cityList.getCities().get(1)));
    }

    @Test
    public void testHasCity() {
        CityList cityList = mockCityList();
        City edmonton = cityList.getCities().get(0);
        // Test Edmonton
        assertTrue(cityList.hasCity(edmonton));

        City vancouver = new City("Vancouver", "BC");
        cityList.add(vancouver);
        // Test Vancouver
        assertTrue(cityList.hasCity(vancouver));
    }

    @Test
    public void testDelete() {
        CityList cityList = mockCityList();

        City vancouver = new City("Vancouver", "BC");
        cityList.add(vancouver);

        // Test removing vancouver
        cityList.delete(vancouver);
        assertEquals(1, cityList.getCities().size());  // Verify size
        assertEquals("Edmonton", cityList.getCities().get(0).getCityName());  // Verify city
        assertEquals("AB", cityList.getCities().get(0).getProvinceName());  // Verify province
    }

    @Test
    public void testDeleteException() {
        CityList cityList = mockCityList();
        City toronto = new City("Toronto", "ON");

        // Test deleting Toronto
        assertThrows(IllegalArgumentException.class, ()-> {
            cityList.delete(toronto);
        });
    }

    @Test
    public void testCountCities() {
        CityList cityList = mockCityList();
        City vancouver = new City("Vancouver", "BC");
        City toronto = new City("Toronto", "ON");
        cityList.add(vancouver);
        cityList.add(toronto);

        assertEquals(3, cityList.countCities());
        cityList.delete(toronto);
        assertEquals(2, cityList.countCities());
        cityList.delete(vancouver);
        assertEquals(1, cityList.countCities());
    }
}