package models.user;

public class UserModel {
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

    public String isInstructor() {
        if (isInstructor) return "TRUE";
        else return "FALSE";
    }

    public void setInstructor(boolean instructor) {
        isInstructor = instructor;
    }
}
