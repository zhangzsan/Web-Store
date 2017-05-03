package lv.javaguru.java2.services.user;

public class UserValidatorImpl implements UserValidator {

    @Override
    public void validate(String firstName,
                         String lastName,
                         String mail,
                         String password) {
        validateFirstName(firstName);
        validateLastName(lastName);
        validateMail(mail);
        validatePassword(password);
        validatePasswordLength(password);
    }

    private void validateFirstName(String firstName) {
        if (firstName == null || firstName.isEmpty()) {
            throw new IllegalArgumentException("First Name must be not empty!");
        }
    }

    private void validateLastName(String lastName) {
        if (lastName == null || lastName.isEmpty()) {
            throw new IllegalArgumentException("Last Name must be not empty!");
        }
    }

    private void validateMail(String mail) {
        if (mail == null || mail.isEmpty()) {
            throw new IllegalArgumentException("Mail must be not empty!");
        }
    }

    private void validatePassword(String password) {
        if (password == null || password.isEmpty()) {
            throw new IllegalArgumentException("Password must be not empty!");
        }
    }

    private void validatePasswordLength(String password) {
        for ( int i = 0; i < password.length(); i++ )
        if (i < 8) {
            throw new IllegalArgumentException("Password must be longer!");
        }
    }

}
