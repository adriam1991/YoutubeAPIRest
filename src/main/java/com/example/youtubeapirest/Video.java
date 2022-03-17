package com.example.youtubeapirest;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Video {

    private String videoId = UUID.randomUUID().toString();
    private String title;
    private String description;
    private String url;


    public Video() {
    }

    public Video(String title, String description, String url) throws Exception {
        checkUrl(url);
        checkTitle(title);
        this.title = title;
        this.description = description;
        this.url = url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    private void checkTitle(String title) throws Exception {
        if(title.length()>10)throw new Exception("El titol te mes de 10 caracters");
    }

    private void checkUrl(String url) throws Exception {
        if(url.contains("www"))throw new Exception("El titol te mes de 10 caracters");
    }

    public String getVideoId() {
        return videoId;
    }


}
