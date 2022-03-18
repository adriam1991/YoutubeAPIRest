package com.example.youtubeapirest;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Video {

    private String id = UUID.randomUUID().toString();
    private String title;
    private String description;
    private String url;


    public Video() {
    }

    public Video(String title, String description, String url) throws Exception {
        checkUrl(url);
        checkTitle(title);
        checkDescription(description);
        this.title = title;
        this.description = description;
        this.url = url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) throws Exception {
        checkTitle(title);
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) throws Exception {
        checkDescription(description);
        this.description = description;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) throws Exception {
        checkUrl(url);
        this.url = url;
    }

    private void checkTitle(String title) throws Exception {
        if(title.length()<10)throw new Exception("El titol te mes de 10 caracters");
    }
    private void checkDescription(String description) throws Exception {
        if (description.equals("")) throw new Exception();
    }
    private void checkUrl(String url) throws Exception {
        if(!url.contains("www"))throw new Exception("invalid URL");
    }

    public String getVideoId() {
        return id;
    }


}
