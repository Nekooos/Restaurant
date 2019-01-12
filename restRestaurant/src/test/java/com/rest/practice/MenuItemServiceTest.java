package com.rest.practice;

import com.rest.practice.Exception.MenuItemNotFoundException;
import com.rest.practice.models.*;
import com.rest.practice.repository.MenuItemRepository;
import com.rest.practice.repository.MenuRepository;
import com.rest.practice.service.MenuItemService;
import com.rest.practice.service.MenuItemServiceImpl;
import com.rest.practice.service.MenuService;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


@ComponentScan(basePackageClasses = {
        MenuItemService.class,
        MenuService.class
})
@SpringBootTest
@RunWith(SpringRunner.class)
@DataJpaTest
public class MenuItemServiceTest {

    @Autowired
    private MenuItemServiceImpl menuItemService;

    @Autowired
    private MenuItemRepository menuItemRepository;

    @Autowired
    private MenuService menuService;

    @Autowired
    private MenuRepository menuRepository;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
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

    @After
    public void cleanUp()  {
        menuItemRepository.deleteAll();
    }

    @Test
    public void getAllMenuItemsTest() {
        List<MenuItem> menuItems = menuItemService.findAll();
        assertThat(menuItems.size()).isEqualTo(6);
    }

    @Test
    public void getMenuItemByIdTest() throws MenuItemNotFoundException {
        MenuItem menuItem2 = menuItemService.find(2L);
        assertThat(menuItem2.getName()).isEqualToIgnoringCase("garlic bread");
    }

    @Test
    public void saveMenuItem() throws MenuItemNotFoundException {
        // Todo set autoincrement to 0 so id can be 7
        Drink drink = new Drink("Juice", 50, "Orange juice", "none", false);

        menuItemRepository.save(drink);
        MenuItem addedDrink = menuItemService.find(19L);

        System.out.println("menu item" + addedDrink.getId());
        assertThat(addedDrink.getName()).isEqualToIgnoringCase("juice");
    }

}
