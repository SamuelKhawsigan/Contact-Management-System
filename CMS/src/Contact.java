import java.io.Serializable;

public class Contact implements Serializable {
    private String name;
    private String phone;
    private String email;

    public Contact(String name, String phone, String email) {
        this.name = name;
        setPhone(phone);
        setEmail(email);
    }

    // Getters
    public String getName() { return name; }
    public String getPhone() { return phone; }
    public String getEmail() { return email; }

    // Setters
    public void setName(String name) { this.name = name; }

    public void setPhone(String phone) {
        if (phone.matches("^[+]?[0-9]{10,13}$")) {
            this.phone = phone;
        } else {
            throw new IllegalArgumentException("Invalid phone number format");
        }
    }

    public void setEmail(String email) {
        if (email.matches("^[\\w.-]+@[\\w.-]+\\.[a-z]{2,}$")) {
            this.email = email;
        } else {
            throw new IllegalArgumentException("Invalid email format");
        }
    }

    @Override
    public String toString() {
        return String.format("%-20s | %-15s | %-30s", name, phone, email);
    }
}