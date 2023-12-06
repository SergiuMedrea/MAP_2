package com.mergiu.QuickByteBE.domain.restaurant;

import com.mergiu.QuickByteBE.domain.address.Address;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class RestaurantService {
    private final RestaurantRepository restaurantRepository;

    @Autowired
    public RestaurantService(RestaurantRepository restaurantRepository) {
        this.restaurantRepository = restaurantRepository;
    }

    public List<Restaurant> getRestaurants() {
        return restaurantRepository.findAll();
    }

    public void addNewRestaurant(Restaurant restaurant) {
        Optional<Restaurant> restaurantOptional = restaurantRepository.findByName(restaurant.getName());
        if(restaurantOptional.isPresent()) {
            throw new IllegalStateException("Restaurant with name " + restaurant.getName() + " already exists");
        }

        restaurantRepository.save(restaurant);
    }

    public void deleteRestaurant(Long restaurantId) {
        boolean exists = restaurantRepository.existsById(restaurantId);

        if (!exists) {
            throw new IllegalStateException("Restaurant with id " + restaurantId + " does not exist");
        }

        restaurantRepository.deleteById(restaurantId);
    }

    @Transactional
    public void updateRestaurant(Long restaurantId, String name, Address address) {
        Restaurant restaurant = restaurantRepository.findById(restaurantId)
                .orElseThrow(() -> new IllegalStateException("Restaurant with id " + restaurantId + " does not exist"));

        if (name != null && !name.isEmpty() && !Objects.equals(restaurant.getName(), name)) {
            restaurant.setName(name);
        }

        if (address != null && !Objects.equals(restaurant.getAddress(), address)) {
            restaurant.setAddress(address);
        }
    }
}
