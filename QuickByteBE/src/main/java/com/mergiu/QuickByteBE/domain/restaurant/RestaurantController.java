package com.mergiu.QuickByteBE.domain.restaurant;

import com.mergiu.QuickByteBE.domain.address.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/restaurants")
public class RestaurantController {

    private final RestaurantService restaurantService;

    @Autowired
    public RestaurantController(RestaurantService restaurantService) {
        this.restaurantService = restaurantService;
    }

    @GetMapping
    public List<Restaurant> getRestaurants() {
        return restaurantService.getRestaurants();
    }

    @PostMapping
    public void addNewRestaurant(@RequestBody Restaurant restaurant) {
        restaurantService.addNewRestaurant(restaurant);
    }

    @DeleteMapping("/{restaurantId}")
    public void deleteRestaurant(@PathVariable Long restaurantId) {
        restaurantService.deleteRestaurant(restaurantId);
    }

    @PutMapping("/{restaurantId}")
    public void updateRestaurant(
            @PathVariable Long restaurantId,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) Address address) {
        restaurantService.updateRestaurant(restaurantId, name, address);
    }
}
