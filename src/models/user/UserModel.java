package models.user;

public class UserModel {
    private int id;
    private String name;
    private String email;
    private String password;
    private boolean isInstructor;

    public UserModel() {
    }

    public UserModel(String name, String email, String password, boolean isInstructor) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.isInstructor = isInstructor;
    }

    public UserModel(int id, String name, String email, String password, boolean isInstructor) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.isInstructor = isInstructor;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String isInstructorDatabase() {
        if (isInstructor) return "TRUE";
        else return "FALSE";
    }

    public boolean isInstructor() {
        return isInstructor;
    }

    public void setInstructor(boolean instructor) {
        isInstructor = instructor;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
