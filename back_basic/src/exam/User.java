package exam;

public class User {
    String name;
    String phone;

    public User(String name, String phone) {
        this.name = name;
        this.phone = phone;
    }

    public String toString() {
        return String.format("이름: %s%n연락처: %s%n", name, phone);
    }
}
