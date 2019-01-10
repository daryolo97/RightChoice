package entità;

public class Admin {

    private String username, password;

    public Admin() {
        this.username = "admin";
        this.password = "admin";
    }

    public String getUsername() {
        return username;
    }


    public String getPassword() {
        return password;
    }

  public boolean verificaAdmin(String username, String password) {
        if(this.username.equals(username) && this.password.equals(password))
            return true;

        return false;
  }

  public void inserisciFeedback(Feedback feedback) {
        feedback.setStato(1);
  }
}
