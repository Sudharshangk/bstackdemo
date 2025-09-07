package services;

public class LoginService {

    private String username;
    private String password;
    private boolean loggedIn;

    public void setCredentials(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public void login() {
        // ✅ Using actual creds
        if ("demouser".equals(username) && "testingisfun99".equals(password)) {
            loggedIn = true;
        } else {
            loggedIn = false;
        }
    }

    public boolean isLoggedIn() {
        return loggedIn;
    }
}
