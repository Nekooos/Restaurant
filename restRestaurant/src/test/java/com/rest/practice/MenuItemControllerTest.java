package com.rest.practice;

import com.rest.practice.controllers.MenuItemController;
import com.rest.practice.models.Appetizer;
import com.rest.practice.models.Dessert;
import com.rest.practice.models.MainCourse;
import com.rest.practice.models.MenuItem;
import com.rest.practice.service.MenuItemService;
import com.rest.practice.service.MenuItemServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class MenuItemControllerTest {

    @Autowired
    MenuItemController menuItemController;

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    MenuItemService menuItemService;

    @Test
    public void getAllmenuItems_response200() throws Exception {
        Appetizer appetizer2 = new Appetizer("Garlic Bread", 50, "Bread with garlic flavor", "none");
        MainCourse mainCourse2 = new MainCourse("Beef", 100, "Beef and fries", "none");
        Dessert dessert1 = new Dessert("Icecream", 50, "Straberry icecream", "nuts");
        List<MenuItem> menuItems = new ArrayList();
        Collections.addAll(menuItems, appetizer2, mainCourse2, dessert1);

        given(this.menuItemService.findAll())
                .willReturn(menuItems);
        mockMvc.perform(get("/item/all")
                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

    @Test
    public void findById_response200() throws Exception {
        given(this.menuItemService.find(new Long(0)))
                .willReturn(new Dessert("Icecream", 50, "Straberry icecream", "nuts"));

        // Todo add parameter
        mockMvc.perform(get("/item/0")
        .contentType(MediaType.APPLICATION_JSON))
        .andDo(print())

        .andExpect(status().is2xxSuccessful());
    }
}
