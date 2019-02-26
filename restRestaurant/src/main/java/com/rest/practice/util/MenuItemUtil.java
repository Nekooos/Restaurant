package com.rest.practice.util;

import com.rest.practice.models.MenuItem;

import java.util.Comparator;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.IntToDoubleFunction;
import java.util.stream.Collectors;

public class MenuItemUtil  {
    public List<MenuItem> sortByPriceHighest(List<MenuItem> menuItems ) {
        menuItems.sort(Comparator.comparingDouble(MenuItem::getPrice));
        return menuItems;
    }

    public List<MenuItem> sortByPriceLowest(List<MenuItem> menuItems ) {
        menuItems.sort(Comparator.comparingDouble(MenuItem::getPrice).reversed());
        return menuItems;
    }

    public List<MenuItem> sortByPriceHighestStream(List<MenuItem> menuItems ) {
        menuItems = menuItems.stream().sorted(Comparator
                .comparing(MenuItem::getPrice)).collect(Collectors.toList());
        return menuItems;
    }

    public List<MenuItem> sortByPriceLowestStream(List<MenuItem> menuItems ) {
        menuItems = menuItems.stream().sorted(Comparator
                .comparing(MenuItem::getPrice).reversed()).collect(Collectors.toList());
        return menuItems;
    }

    public List<MenuItem> filterPrice(List<MenuItem> menuItems, double price) {
        List<MenuItem> filteredList = menuItems.stream()
                .filter(item -> item.getPrice() > price)
                .collect(Collectors.toList());
        return filteredList;
    }

    public List<MenuItem> filterAllergies(List<MenuItem> menuItems, String allergies) {
        List<MenuItem> filteredList = menuItems.stream()
                .filter(item -> !item.getAllergies().equals(allergies))
                .collect(Collectors.toList());
        return filteredList;
    }

    public double calculatePrice(double price, MenuItem menuItem) {
        CalculatePrice calculatedPrice = (double p) -> menuItem.getPrice() * 0.2;

        IntToDoubleFunction testIntToDouble = (int test) -> 5.1 + 0.15 * test;

        Function<String, Integer> wordCount = (String s) -> s.split(" ").length;

        BiFunction<String, Integer, Boolean> exceedsMaxLength = (s, maxLength) -> {
            int actualLength = s.length();
            return actualLength > maxLength;
        };

        calculatedPrice.calculate(50.5);

        exceedsMaxLength.apply("derp", 5);

        int wordlength = wordCount.apply("hello");

        return calculatedPrice.calculate(5.0);
    }
}
