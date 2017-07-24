package cucumber.data;

// todo: use this for data deserialization instead
public class User {
  public String username;
  public String name;
  public String email;
  public String password;

  String getUsername() {
    return username;
  }

  void setUsername(String username) {
    this.username = username;
  }

  String getName() {
    return name;
  }

  void setName(String name) {
    this.name = name;
  }

  String getEmail() {
    return email;
  }

  void setEmail(String email) {
    this.email = email;
  }

  String getPassword() {
    return password;
  }

  void setPassword(String password) {
    this.password = password;
  }
}
