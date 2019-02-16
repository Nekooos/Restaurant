package com.rest.practice;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rest.practice.Exception.MenuItemNotFoundException;
import com.rest.practice.controllers.MenuItemController;
import com.rest.practice.models.Appetizer;
import com.rest.practice.models.Dessert;
import com.rest.practice.models.MainCourse;
import com.rest.practice.models.MenuItem;
import com.rest.practice.service.MenuItemService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.willReturn;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
/*
@ComponentScan(basePackageClasses = {
        MenuItemService.class,
        MenuItemController.class
})
*/
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class MenuItemControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    MenuItemService menuItemService;

    @Test
    public void menuItemServiceMockShouldNotBeNull() {
        assertThat(this.menuItemService).isNotNull();
    }

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
                .andExpect(jsonPath("$[1].name").value("Beef"))
                .andExpect(status().is2xxSuccessful());
    }

    @Test
    public void findById_response200() throws Exception {
        given(this.menuItemService.find(new Long(0)))
                .willReturn(new Dessert("Icecream", 50, "Straberry icecream", "nuts"));

        // Todo add parameter
        mockMvc.perform(get("/item/{id}", 0L)
            .contentType(MediaType.APPLICATION_JSON))
            .andDo(print())
            .andExpect(status().is2xxSuccessful())
            .andExpect(jsonPath("$.name").value("Icecream"));
    }

    @Test
    public void findById_response404() throws Exception {
        given(this.menuItemService.find(1L))
                .willThrow(new MenuItemNotFoundException("Menu Item was not found"));
        mockMvc.perform(get("/item/{id}", 1L)
                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void saveMenuItem_response201() throws Exception {
        MainCourse mainCourse = new MainCourse("Beef", 100, "Beef and fries", "none");
        mainCourse.setId(2L);
        String json = "{ \"name\" : \"beef\", \"price\" : 100, \"description\" : \"Beef and fries\", \"secret\" : \"none\", \"type\" : \"maincourse\"}";
        // todo @requestbody @pathparam
        given(this.menuItemService.save(mainCourse))
                .willReturn(mainCourse);
        mockMvc.perform(post("/item/save")
                .contentType(MediaType.APPLICATION_JSON).content(json))
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("$.name").value("beef"));
    }
}
