import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class ContactManager {
    private static final String FILE_NAME = "contacts.txt";
    private static ArrayList<Contact> contacts = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        loadContacts();
        
        while (true) {
            System.out.println("\n=== Contact Management System ===");
            System.out.println("1. Add Contact");
            System.out.println("2. View All Contacts");
            System.out.println("3. Search Contact");
            System.out.println("4. Update Contact");
            System.out.println("5. Delete Contact");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");

            try {
                int choice = Integer.parseInt(scanner.nextLine());
                
                switch (choice) {
                    case 1:
                        addContact();
                        break;
                    case 2:
                        viewContacts();
                        break;
                    case 3:
                        searchContact();
                        break;
                    case 4:
                        updateContact();
                        break;
                    case 5:
                        deleteContact();
                        break;
                    case 6:
                        saveContacts();
                        System.out.println("Contacts saved. Goodbye!");
                        System.exit(0);
                    default:
                        System.out.println("Invalid option!");
                }
            } catch (NumberFormatException e) {
                System.out.println("Please enter a number 1-6");
            }
        }
    }

    private static void addContact() {
        System.out.println("\n--- Add New Contact ---");
        System.out.print("Name: ");
        String name = scanner.nextLine();
        
        System.out.print("Phone: ");
        String phone = scanner.nextLine();
        
        System.out.print("Email: ");
        String email = scanner.nextLine();

        try {
            Contact newContact = new Contact(name, phone, email);
            contacts.add(newContact);
            System.out.println("Contact added successfully!");
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void viewContacts() {
        if (contacts.isEmpty()) {
            System.out.println("No contacts found.");
            return;
        }
        
        System.out.println("\n--- All Contacts ---");
        System.out.printf("%-20s | %-15s | %-30s%n", "Name", "Phone", "Email");
        System.out.println("-".repeat(70));
        for (int i = 0; i < contacts.size(); i++) {
            System.out.println((i + 1) + ". " + contacts.get(i));
        }
    }

    private static void searchContact() {
        System.out.print("\nEnter name to search: ");
        String searchTerm = scanner.nextLine().toLowerCase();
        boolean found = false;
        
        System.out.println("\n--- Search Results ---");
        for (Contact contact : contacts) {
            if (contact.getName().toLowerCase().contains(searchTerm)) {
                System.out.println(contact);
                found = true;
            }
        }
        
        if (!found) {
            System.out.println("No contacts found matching '" + searchTerm + "'");
        }
    }

    private static void updateContact() {
        viewContacts();
        if (contacts.isEmpty()) return;
        
        System.out.print("\nEnter contact number to update: ");
        try {
            int index = Integer.parseInt(scanner.nextLine()) - 1;
            if (index < 0 || index >= contacts.size()) {
                System.out.println("Invalid contact number!");
                return;
            }
            
            Contact contact = contacts.get(index);
            System.out.println("\nEditing: " + contact);
            
            System.out.print("New name (leave blank to keep current): ");
            String name = scanner.nextLine();
            if (!name.isBlank()) contact.setName(name);
            
            System.out.print("New phone (leave blank to keep current): ");
            String phone = scanner.nextLine();
            if (!phone.isBlank()) contact.setPhone(phone);
            
            System.out.print("New email (leave blank to keep current): ");
            String email = scanner.nextLine();
            if (!email.isBlank()) contact.setEmail(email);
            
            System.out.println("\nContact updated successfully!");
        } catch (NumberFormatException e) {
            System.out.println("Please enter a valid number");
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void deleteContact() {
        viewContacts();
        if (contacts.isEmpty()) return;
        
        System.out.print("\nEnter contact number to delete: ");
        try {
            int index = Integer.parseInt(scanner.nextLine()) - 1;
            if (index < 0 || index >= contacts.size()) {
                System.out.println("Invalid contact number!");
                return;
            }
            
            Contact removed = contacts.remove(index);
            System.out.println("\nDeleted contact: " + removed.getName());
        } catch (NumberFormatException e) {
            System.out.println("Please enter a valid number");
        }
    }

    @SuppressWarnings("unchecked")
    private static void loadContacts() {
        File file = new File(FILE_NAME);
        if (file.exists()) {
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
                contacts = (ArrayList<Contact>) ois.readObject();
                System.out.println("Loaded " + contacts.size() + " contacts from file.");
            } catch (IOException | ClassNotFoundException e) {
                System.err.println("Error loading contacts: " + e.getMessage());
            }
        }
    }

    private static void saveContacts() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            oos.writeObject(contacts);
        } catch (IOException e) {
            System.err.println("Error saving contacts: " + e.getMessage());
        }
    }
}