package models.course;

import java.sql.Date;

public class CourseModel {
    private int id;
    private String title;
    private String description;
    private String banner;
    private Date createdAt;
    private String requirements;
    private int tagId;
    private int instructorUserId;

    public CourseModel() {
    }

    public CourseModel(String title, String description, String banner, Date createdAt, String requirements, int tagId, int instructorUserId) {
        this.title = title;
        this.description = description;
        this.banner = banner;
        this.createdAt = createdAt;
        this.requirements = requirements;
        this.tagId = tagId;
        this.instructorUserId = instructorUserId;
    }

    public CourseModel(int id, String title, String description, String banner, Date createdAt, String requirements, int tagId, int instructorUserId) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.banner = banner;
        this.createdAt = createdAt;
        this.requirements = requirements;
        this.tagId = tagId;
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

    public int getTagId() {
        return tagId;
    }

    public void setTagId(int tagId) {
        this.tagId = tagId;
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
}
