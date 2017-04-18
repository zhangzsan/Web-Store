package lv.javaguru.java2.services.user;

public interface UserValidator {

    void validate(String firstName,
                  String lastName,
                  String mail,
                  String password);

}
