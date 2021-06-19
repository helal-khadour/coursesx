package models.course;

import java.sql.Date;
import java.util.ArrayList;

import models.video.VideoModel;

public class CourseModel {
    private int id;
    private String title;
    private String description;
    private String banner;
    private Date createdAt;
    private String requirements;
    private String topic;
    private int instructorUserId;
    private ArrayList<VideoModel> videos;

    public CourseModel() {
    }

    public CourseModel(String title, String description, String banner, String requirements, String topic, int instructorUserId) {
        this.title = title;
        this.description = description;
        this.banner = banner;
        this.requirements = requirements;
        this.topic = topic;
        this.instructorUserId = instructorUserId;
        this.videos = new ArrayList<>();
    }

    public CourseModel(int id, String title, String description, String banner, Date createdAt, String requirements, String topic, int instructorUserId) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.banner = banner;
        this.createdAt = createdAt;
        this.requirements = requirements;
        this.topic = topic;
        this.instructorUserId = instructorUserId;
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

    public String getBanner() {
        return banner;
    }

    public void setBanner(String banner) {
        this.banner = banner;
    }

    public String getRequirements() {
        return requirements;
    }

    public void setRequirements(String requirements) {
        this.requirements = requirements;
    }


    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public int getInstructorUserId() {
        return instructorUserId;
    }

    public void setInstructorUserId(int instructorUserId) {
        this.instructorUserId = instructorUserId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public ArrayList<VideoModel> getVideos() {
        return videos;
    }

    public void setVideos(ArrayList<VideoModel> videos) {
        this.videos = videos;
    }
}
