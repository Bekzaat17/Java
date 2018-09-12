package sample;

public class User {
    private String name;
    private String lastname;
    private String username;
    private String password;
    private String location;
    private String gender;

    public User(String name, String lastname, String username, String password, String location, String gender) {
        this.name = name;
        this.lastname = lastname;
        this.username = username;
        this.password = password;
        this.location = location;
        this.gender = gender;
    }

    public User() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
