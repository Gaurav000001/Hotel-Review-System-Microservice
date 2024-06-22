package com.micro.user.services;

import com.micro.user.exceptions.UserException;
import com.micro.user.entities.Hotel;
import com.micro.user.entities.Rating;
import com.micro.user.external.services.HotelService;
import com.micro.user.repositories.UserRepository;
import com.micro.user.entities.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.*;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private HotelService hotelService;

    private Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Override
    public User saveUser(User user) {
        Optional<User> emailOpt = userRepository.findByEmail(user.getEmail());
        Optional<User> phoneOpt = userRepository.findByPhone(user.getPhone());

        if(emailOpt.isPresent()) throw new UserException("User already present with Email: " + user.getEmail());
        if(phoneOpt.isPresent()) throw new UserException("User already present with Phone: " + user.getPhone());

        user.setUserId(UUID.randomUUID().toString());
        return userRepository.save(user);
    }

    @Override
    public List<User> getAllUser() {
        List<User> users = userRepository.findAll();

        if(users.isEmpty()) throw new UserException("Users not found");

        return users;
    }

    @Override
    public User getUser(String userId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new UserException("User not found with userId: " + userId));

        /*
        when we do
        ArrayList<Rating> userRatings = restTemplate.getForObject("http://RATING-SERVICE/micro/ratings/users/" + userId + "/", ArrayList.class);
        restTemplate will provide the ArrayList but
        it will not persist the ratings as Rating object inside the ArrayList<Rating>
        instead it will put data inside the ArrayList as LinkedHashSet where key will be the id
         */

        Rating[] userRatingsArray = restTemplate.getForObject("http://RATING-SERVICE/micro/ratings/users/" + userId + "/", Rating[].class);

        if(userRatingsArray.length > 0) {
            List<Rating> userRatingsList = Arrays.stream(userRatingsArray).toList();
            List<Rating> userRatings = userRatingsList.stream().map(rating -> {
//            request for hotel information from HotelService.
//            Hotel hotel = restTemplate.getForEntity("http://HOTEL-SERVICE/micro/hotels/" + rating.getHotelId() + "/", Hotel.class).getBody();
                Hotel hotel = hotelService.getHotel(rating.getHotelId());
                rating.setHotel(hotel);

                return rating;
            }).toList();

            user.setRatings(userRatings);
        }
        else user.setRatings(new ArrayList<>());

        return user;
    }
}
