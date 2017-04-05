package lv.javaguru.java2.services.User;

public interface UserValidator {

    void validate(String firstName,
                  String lastName,
                  String mail,
                  String password);

}
