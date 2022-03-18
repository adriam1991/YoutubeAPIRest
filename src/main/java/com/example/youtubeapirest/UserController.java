package com.example.youtubeapirest;


import net.minidev.json.JSONObject;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    private UserService userService;
    public UserController(UserService userService) {this.userService = userService;}


    @PostMapping("/users")
    public User createUser(@RequestBody User userToCreate) {
        return userService.createUser(userToCreate);
    }

    @PostMapping("/users/{userId}/videos")
    public Video createVideosOnUser(@PathVariable String userId,@RequestBody  Video videos) throws Exception {
        return userService.assignVideosOnUser(userId,videos);

    }

    @GetMapping("/users")
    public List<User> getUsers() {
        return userService.getUsers();
    }

    @GetMapping("/users/{userId}/videos")
    public List<Video> getVideos(@PathVariable String userId) throws Exception {
        return userService.getVideos(userId);
    }

    @GetMapping("/users/{userId}/videos/{videoId}")
    public Video getVideo(@PathVariable String userId, @PathVariable String videoId) throws Exception {
        return userService.getVideo(userId, videoId);
    }

    @DeleteMapping("/users/{userId}/videos")
    public void removeAllVideos(@PathVariable String userId) throws Exception {
        userService.removeAllVideos(userId);
    }

    @PutMapping("/users/{userId}")
    public void updateUser(@RequestBody User userToUpdate, @PathVariable String userId) throws Exception {
        userService.updateUser(userToUpdate,userId);
    }
    @PostMapping("/users/{userId}/videos/{videoId}")
    public Valuation valuateVideo(@PathVariable String userId,@PathVariable String videoId,@RequestBody Valuation valuationToCreate) throws Exception {
        return userService.valuateOnVideo(userId,videoId,valuationToCreate);

    }

}
