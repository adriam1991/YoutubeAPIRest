package com.example.youtubeapirest;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class User {

    private String id = UUID.randomUUID().toString();
    private String name;
    private String email;
    private String password;
    private List<Video> videos = new ArrayList<>();

    public User() {
    }

    public User(String id, String name, String email, String password) throws Exception {
        checkPassword(password);
        checkName(name);
        checkEmail(email);
        this.name = name;
        this.email = email;
        this.password = password;
    }

    private void checkPassword(String password) throws Exception {
        if(!password.toUpperCase().matches("([0-9a-zA-Z]){7,15}$"))throw new Exception("invalid password");
    }

    private void checkName(String name) throws Exception {
        if (name.equals("")) throw new Exception();
    }
    private void checkEmail(String email) throws Exception {
        if (email.equals("")) throw new Exception("invalid email");
    }

    public String getUserId() {
        return id;
    }
    public List<Video> getVideos() {
        return videos;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) throws Exception {
        checkName(name);
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) throws Exception {
        checkEmail(email);
        this.email = email;
    }


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) throws Exception {
        checkPassword(password);
        this.password = password;
    }

    public Video createVideo(Video videoToCreate) {
        videos.add(videoToCreate);
        return videoToCreate;
    }


    public Video findVideo(String videoId) throws Exception {
        for (Video video : videos) {
            if (video.getVideoId().equals(videoId)) {
                return video;
            }
        }
        throw new Exception("No s'ha trobat");
    }

   }
