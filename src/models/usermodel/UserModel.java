package models.usermodel;

public class UserModel {
    protected String userName;
    protected String email;
    protected String password;
    public UserModel ()
    {
    }
    public UserModel(String userName, String email, String password)
    {
        this.userName=userName;
        this.email=email;
        this.password=password;
    }
    public void setUserName(String userName)
    {
        this.userName=userName;
    }
    public String getUserName()
    {
        return this.userName;
    }
    public void setEmail(String userName)
    {
        this.email=email;
    }
    public String getEmail()
    {
        return this.email;
    }
    public void setPassword(String userName)
    {
        this.password=password;
    }
    public String getPassword()
    {
        return this.password;
    }
}
