package com.rest.practice;

import com.rest.practice.Exception.InternalServerErrorException;
import com.rest.practice.Exception.RestaurantNotFoundException;
import com.rest.practice.models.Menu;
import com.rest.practice.models.Restaurant;
import com.rest.practice.repository.RestaurantRepository;
import com.rest.practice.service.RestaurantService;
import com.rest.practice.service.RestaurantServiceImpl;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.MockitoRule;
import org.mockito.stubbing.Answer;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.*;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class RestaurantServiceTest {


    @InjectMocks
    RestaurantServiceImpl restaurantService;

    @Mock
    RestaurantRepository restaurantRepository;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void getRestaurantById() throws RestaurantNotFoundException {
        List<Menu> menu = new ArrayList<>();
        Optional<Restaurant> restaurant = Optional.of(new Restaurant("Bubbas Kött", "fisk", 070666666, "Delfingatan 8 A 333 33 Dolphinville", menu));
        restaurant.get().setId(1L);
        when(restaurantRepository.findById(1L)).thenReturn(restaurant);
        Restaurant getRestaurant = restaurantService.get(1L);
        assertThat(getRestaurant.getRestaurantName()).isEqualTo("Bubbas Kött");
    }

    @Test
    public void addRestaurant() throws InternalServerErrorException {
        List<Menu> menu = new ArrayList();
        Restaurant restaurant = new Restaurant("Bubbas Kött", "fisk", 07066666, "Delfingatan 8 A 333 33 Dolphinville", menu);
        when(restaurantRepository.save(restaurant)).thenReturn(restaurant);
        assertThat(restaurantService.save(restaurant).getRestaurantName()).isEqualTo("Bubbas Kött");
    }

    @Test
    public void deleteRestaurantById() throws RestaurantNotFoundException {
        List<Menu> menu = new ArrayList<>();
        Optional<Restaurant> restaurant = Optional.of(new Restaurant("Bubbas Kött", "fisk", 070666666, "Delfingatan 8 A 333 33 Dolphinville", menu));
        restaurant.get().setId(1L);
        restaurantRepository.deleteById(1L);
        verify(restaurantRepository, times(1)).deleteById(eq(restaurant.get().getId()));
    }

    @Test
    public void changeRestaurantName() {
        List<Menu> menu = new ArrayList<>();
        Optional<Restaurant> restaurant = Optional.of(new Restaurant("Bubbas Kött", "fisk", 070666666, "Delfingatan 8 A 333 33 Dolphinville", menu));
    }
}
