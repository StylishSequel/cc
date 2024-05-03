package Hotel;

import Person.Customer;
import Person.Employee;
import Room.*;
import Service.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import ConnectDatabase.ConnectDatabase;

public class Hotel {
    private String name;
    private String address;
    List<Room> rooms;
    List<Customer> customers;
    List<Employee> employees;
    List<Service> services;
    List<Service> tasks;

    public Hotel(String name, String address) {
        ConnectDatabase connector = new ConnectDatabase();
        
        this.name = name;
        this.address = address;
        rooms = connector.queryRooms();
        rooms.add(new StandardRoom(true));
        customers = new ArrayList<>();
        employees = new ArrayList<>();
        services = new ArrayList<>();
        tasks = new ArrayList<>();
    }

    public String getName() {
        return this.name;
    }

    public String getAddress() {
        return this.address;
    }

    public List<Customer> getCustomers() {
        return this.customers;
    }

    public List<Employee> getEmployees() {
        return this.employees;
    }

    public void printEmployee() {
        for (Employee employee : employees) {
            System.out.println(employee.toString());
        }
    }

    public List<Service> getServices() {
        return this.services;
    }

    public void printRooms() {
        System.out.println("Rooms in hotel:");
        rooms.forEach(r -> System.out.println(r.toString()));
    }

    public void addCustomer() {
        // Add customer
        System.out.println("Add customer:");
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter customer name: ");
        String name = scan.nextLine();
        System.out.println("Enter customer gender(true for male, false for female): ");
        Boolean gender = scan.nextBoolean();
        scan.nextLine();
        System.out.println("Enter customer phone: ");
        String phone = scan.nextLine();
        System.out.println("Enter is active:");
        Boolean is_active = scan.nextBoolean();
        ConnectDatabase connector = new ConnectDatabase();
        Customer customer = connector.insertCustomer(name, gender, phone, is_active);
        customers.add(customer);
        scan.close();
    }

    public void addRoom(Room room) {
        rooms.add(room);
    }

    public void addRoom() {
        Scanner scan = new Scanner(System.in);
        // Add room
        System.out.println("Add room:");
        System.out.println("Choose room type: 1. Standard 2. Deluxe 3. Suite");
        int choice = scan.nextInt();
        scan.nextLine();

        System.out.println("Enter room price: ");
        double price = scan.nextDouble();
        System.out.println("Enter number of beds: ");
        int beds = scan.nextInt();
        scan.nextLine();

        switch (choice) {
            case 1:
                System.out.println("Is room having shower? 1. Yes 2. No ");
                int shower = scan.nextInt();
                scan.nextLine();
                StandardRoom newSR = new StandardRoom(price, beds, shower == 1);
                this.addRoom(newSR);
                break;

            case 2:
                System.out.println("Enter furniture:");
                String furniture = scan.nextLine();
                DeluxeRoom newDR = new DeluxeRoom(price, beds, furniture);
                this.addRoom(newDR);
                break;

            case 3:
                System.out.println("Enter electric devices:");
                String devices = scan.nextLine();
                SuiteRoom newSDR = new SuiteRoom(price, beds, devices);
                this.addRoom(newSDR);
                break;

            default:
                System.out.println("Invalid choice");
                break;
        }
        scan.close();
    }

    public void removeRoom() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter room id to remove: ");
        int id = scan.nextInt();
        Room room = rooms.stream().filter(r -> r.getId() == id).findFirst().orElse(null);
        if (room == null) {
            System.out.println("Room not found");
            scan.close();
            return;
        }
        rooms.remove(room);
        System.out.println("Room removed successfully");
        scan.close();
    }

    public void removeRoom(Room room) {
        rooms.remove(room);
    }

    public void checkOut() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter customer id: ");
        int id = scan.nextInt();
        Customer customer = customers.stream().filter(c -> c.getID() == id).findFirst().orElse(null);
        if (customer == null) {
            System.out.println("Customer not found");
            return;
        }
        customer.getBookedRoom().stream().forEach(r -> r.toString());
        System.out.println("Enter room id to check out: ");
        int roomId = scan.nextInt();
        scan.nextLine();
        Room room = customer.getBookedRoom().stream().filter(r -> r.getId() == roomId).findFirst().orElse(null);
        if (room == null) {
            System.out.println("Room not found");
            return;
        }
        room.setAvailable(true);
        ConnectDatabase connector = new ConnectDatabase();
        connector.updateAvailableRoom(roomId);

        if(customer.getBookedRoom().size() == 0){
            connector.updateActiveCustomer(customer.getID());
            customers.remove(customer);
        }
        System.out.println("Room checked out successfully");
    }

    public void checkOut(Customer customer) {
        customer.getBookedRoom().stream().forEach(r -> r.setAvailable(true));
        customers.remove(customer);
    }

    public List<Room> getAvailableRoom() {
        return rooms.stream().filter(r -> r.isAvailable()).toList();
    }

    public void addService(Service service) {
        services.add(service);
    }

    public void printAllBill() {
        customers.stream().forEach(c -> System.out.println(c.printBill()));
        double total = customers.stream().mapToDouble(c -> c.printBill()).sum();
        System.out.println("Total bill: " + total);
    }

    public void caculate() {
        double salary = employees.stream().mapToDouble(e -> e.getSalary()).sum();
        double bills = customers.stream().mapToDouble(c -> c.getBill()).sum();
        double profit = bills - salary;
        System.out.println("Profit: " + profit);
    }

}
