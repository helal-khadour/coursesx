package models.video;

public class VideoModel {
    private int id;
    private String name;
    private String url;
    private int courseId;

    public VideoModel() {
    }

    public VideoModel(String name, String url, int courseId) {
        this.name = name;
        this.url = url;
        this.courseId = courseId;
    }

    public VideoModel(int id, String name, String url, int courseId) {
        this.id = id;
        this.name = name;
        this.url = url;
        this.courseId = courseId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }
}
