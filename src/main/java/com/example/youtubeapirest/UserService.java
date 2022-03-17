package com.example.youtubeapirest;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    private List<User> users = new ArrayList<>();


    public User createUser(User userToCreate) {
        users.add(userToCreate);
        return userToCreate;
    }

    private User findUser(String userID) throws Exception {
        for (User user : new ArrayList<>(users)) {
            if (user.getUserId().equals(userID)) {
                return user;
            }
        }
        throw new Exception("No s'ha trobat");
    }


    public Video assignVideosOnUser(String userId, Video videos) throws Exception {
        User user = findUser(userId);
        return user.createVideo(videos);

    }
    public List<User> getUsers() {
        return users;
    }
    public Video getVideo(String userId,String videoId) throws Exception {
        User user = findUser(userId);
        Video video = user.getVideo(videoId);
        return video;
    }

    public List<Video> getVideos( String userId) throws Exception {
        User user = findUser(userId);
        List<Video> videos = user.getVideos();
        return videos;
    }


    public void removeAllVideos( String userId) throws Exception {
        User user = findUser(userId);
        user.getVideos().clear();
    }

    public User updateUser(User userToUpdate, String userId) throws Exception {

                for (User user : users) {
                if (user.getUserId().equals(userId)) {
                    user.setName(userToUpdate.getName());
                    user.setEmail(userToUpdate.getEmail());
                    user.setPassword(userToUpdate.getPassword());
                    return user;
                }
            }
            throw new Exception("No s'ha trobat");
        }
    }

