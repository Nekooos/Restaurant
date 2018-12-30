package com.rest.practice;

import com.rest.practice.models.*;
import com.rest.practice.repository.MenuItemRepository;
import com.rest.practice.service.MenuItemService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@RunWith(SpringRunner.class)
@DataJpaTest
public class MenuItemControllerTest {

    //@Autowired
    //private MenuItemService menuItemService;

    @Autowired
    private MenuItemRepository menuItemRepository;

    @Before
    public void setUp() {
        Appetizer appetizer1 = new Appetizer("Soup", 50, "Soup with shrimps", "crab");
        Appetizer appetizer2 = new Appetizer("Garlic Bread", 50, "Bread with garlic flavor", "none");
        MainCourse mainCourse1 = new MainCourse("Chicken", 100, "chicken with curry", "duck");
        MainCourse mainCourse2 = new MainCourse("Beef", 100, "Beef and fries", "none");
        Dessert dessert1 = new Dessert("Icecream", 50, "Straberry icecream", "nuts");
        Drink drink1 = new Drink("Guinness", 50, "beer", "none", true);
        menuItemRepository.save(appetizer1);
        menuItemRepository.save(appetizer2);
        menuItemRepository.save(mainCourse1);
        menuItemRepository.save(mainCourse2);
        menuItemRepository.save(dessert1);
        menuItemRepository.save(drink1);
    }

    @Test
    public void GetAllMenuItemsTest() {
        List<MenuItem> menuItems = menuItemRepository.findAll();
        assertThat(menuItems.size()).isEqualTo(6);
    }

}
