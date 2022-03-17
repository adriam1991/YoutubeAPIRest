package com.example.youtubeapirest;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class User {

    private String userId = UUID.randomUUID().toString();
    private String name;
    private String email;
    private String password;
    private List<Video> videos = new ArrayList<>();

    public User() {
    }

    public User(String id, String name, String email, String password) throws Exception {
        checkPassword(password);
        this.name = name;
        this.email = email;
        this.password = password;
    }

    private void checkPassword(String password) throws Exception {
        if(password.length()>7&&password.matches("[1-9]*"))throw new Exception();
    }

    public String getUserId() {
        return userId;
    }
    public List<Video> getVideos() {
        return videos;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Video createVideo(Video videoToCreate) {
        videos.add(videoToCreate);
        return videoToCreate;
    }

    private Video findVideo(String videoID) throws Exception {
        for (Video video : new ArrayList<>(videos)) {
            if (video.getVideoId().equals(videoID)) {
                return video;
            }
        }
        throw new Exception("No s'ha trobat");
    }

    public Video getVideo(String videoId) throws Exception {
        for (Video video : videos) {
            if (video.getVideoId().equals(videoId)) {
                return video;
            }
        }
        throw new Exception("No s'ha trobat");
    }

   }
