package lv.javaguru.java2.services;

public interface EditUserService {

    void edit(Long userId,
              String newFirstName,
              String newLastName,
              String newMail,
              String newPassword);

}
