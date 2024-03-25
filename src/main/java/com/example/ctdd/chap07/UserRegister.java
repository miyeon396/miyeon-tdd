package com.example.ctdd.chap07;

public class UserRegister {
    private WeakPasswordChecker passwordChecker;
    private UserRepository userRepository;
    private EmailNotifiler emailNotifiler;

    public UserRegister(WeakPasswordChecker passwordChecker,
                        UserRepository userRepository,
                        EmailNotifiler emailNotifiler) {
        this.passwordChecker = passwordChecker;
        this.userRepository = userRepository;
        this.emailNotifiler = emailNotifiler;
    }

    public void register(String id, String pw, String email) {
        if (passwordChecker.checkPasswordWeak(pw)) {
            throw new WeakPasswordException();
        }
        User user = userRepository.findById(id);
        if (user != null) {
            throw new DupIdException();
        }
        userRepository.save(new User("id", "pw", "email"));
        emailNotifiler.sendRegisterEmail(email);
    }
}
