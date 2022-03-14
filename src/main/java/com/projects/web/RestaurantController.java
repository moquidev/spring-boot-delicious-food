package com.projects.web;

import com.projects.model.api.request.RestaurantRequest;
import com.projects.model.api.response.RestaurantResponse;
import com.projects.service.RestaurantService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.projects.util.Constants.GET;
import static com.projects.util.Constants.GET_RESTAURANT_CATEGORY;
import static com.projects.util.Constants.POST_RESTAURANT;
import static com.projects.util.Constants.RS_TAG_NAME;
import static com.projects.util.Constants.RS_TAG_DESC;
import static com.projects.util.Constants.POST;

@RestController
@RequestMapping("api/v1.0/restaurants")
@Api(tags = RS_TAG_NAME, description = RS_TAG_DESC)
@Validated
@Slf4j
@RequiredArgsConstructor
public class RestaurantController {
  
  @Autowired
  private RestaurantService restaurantService;
  
  @PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE},
    produces = {MediaType.APPLICATION_STREAM_JSON_VALUE, MediaType.APPLICATION_JSON_VALUE})
  @ApiOperation(value = POST_RESTAURANT, response = RestaurantResponse.class, httpMethod = POST)
  public RestaurantResponse postRestaurant(@RequestBody RestaurantRequest restaurantRequest) {
    return restaurantService.createRestaurant(restaurantRequest);
  }
  
  @GetMapping(value = "/{category}",
    produces = {MediaType.APPLICATION_STREAM_JSON_VALUE, MediaType.APPLICATION_JSON_VALUE})
  @ApiOperation(value = GET_RESTAURANT_CATEGORY, response = RestaurantResponse.class, httpMethod = GET)
  public List<RestaurantResponse> getRestaurantByCategory(@PathVariable(value = "category") String category) {
    return restaurantService.findByCategory(category);
  }
  
}
