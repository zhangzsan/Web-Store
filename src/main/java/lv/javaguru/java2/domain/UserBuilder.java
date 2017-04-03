package lv.javaguru.java2.domain;

public class UserBuilder {

    private String firstName;
    private String lastName;
    private String mail;
    private String password;


    private UserBuilder() {}

    public static UserBuilder createUser() {
        return new UserBuilder();
    }

    public User build() {
        User user = new User();
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setMail(mail);
        user.setPassword(password);
        return user;
    }

    public UserBuilder withFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public UserBuilder withLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public UserBuilder withMail(String mail) {
        this.mail = mail;
        return this;
    }

    public UserBuilder withPassword(String password) {
        this.password = password;
        return this;
    }

}
