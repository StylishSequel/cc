import java.sql.SQLException;
import java.util.Scanner;

import Person.*;
import ConnectDatabase.*;
import Room.*;
import Service.*;
import Hotel.*;
public class Main {
    public static void main(String[] args) throws SQLException {
        Manager newManager = new Manager(1, "duc", true, "123", true, 1, 100, "manager");
        Hotel h = new Hotel("Threeboys", "Ha Noi");
        Customer c = new Customer(1, "thanh", true, "092345234");
        Boolean flag = true;
        while (flag) {
            
            System.out.println("Choose your option.");
            System.out.println("1. For Manager");
            System.out.println("2. For Customer");
            System.out.println("3. For Hotel");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            Scanner in = new Scanner(System.in);
            int choice = in.nextInt();
            switch (choice) {
                case 1: {
                    Boolean flag1 = true;
                    while (flag1) {
                        System.out.println("Choose your option.");
                        System.out.println("1. For add employee");
                        System.out.println("2. For remove employee");
                        System.out.println("3. For add service");
                        System.out.println("4. For remove service");
                        System.out.println("5. For exit");
                        System.out.print("Enter your choice: ");
                        Scanner in2 = new Scanner(System.in);
                        int choice2 = in2.nextInt();
                        switch (choice2) {
                            case 1: {
                                newManager.addEmployee(h);
                                break;
                            }
                            case 2: {
                                newManager.removeEmployee(h);
                                break;
                            }
                            case 3: {
                                newManager.addService(h);
                                break;
                            }
                            case 4: {
                                newManager.removeService(h);
                                break;
                            }
                            case 5: {
                                flag1 = false;
                                break;
                            }
                            default: {
                                System.out.println("Invalid choice.");

                            }
                        }

                    }
                }
                case 2: {
                    Boolean flag2 = true;
                    while (flag2) {
                        System.out.println("Choose your option.");
                        System.out.println("1. For book room.");
                        System.out.println("2. For book service.");
                        System.out.println("3. For print book room.");
                        System.out.println("4. For print book service.");
                        System.out.println("5. For exit.");
                        System.out.print("Enter your choice: ");
                        Scanner in2 = new Scanner(System.in);
                        int choice2 = in2.nextInt();
                        switch (choice2) {
                            case 1: {

                                c.bookRoom(h);
                                break;
                            }
                            case 2: {
//                                c.bookService(h);
                                break;
                            }
                            case 3: {
                                c.printBookedRoom();
                                break;
                            }
                            case 4: {
                                c.printServices();
                                break;
                            }
                            case 5: {
                                flag2 = false;
                                break;
                            }
                            default:
                                System.out.println("Invalid choice.");
                        }
                    }
                    break;
                }
                case 3: {
                    Boolean flag3 = true;
                    while (flag3) {
                        System.out.println("Choose your option.");
                        System.out.println("1. For add customer.");
                        System.out.println("2. For add room.");
                        System.out.println("3. For remove room.");
                        System.out.println("4. For checkout.");
                        System.out.println("5. For get available room.");
                        System.out.println("5. For exit.");
                        System.out.print("Enter your choice: ");
                        Scanner in2 = new Scanner(System.in);
                        int choice2 = in2.nextInt();
                        switch (choice2) {
                            case 1: {
                                h.addCustomer();
                                break;
                            }
                            case 2: {
//                            h.addRoom();
//                            break;
                            }
                            case 3: {
                                h.removeRoom();
                                break;
                            }
                            case 4: {
                                h.checkOut();
                                break;
                            }
                            case 5: {
                                h.getAvailableRoom();
                                break;
                            }
                            case 6: {
                                flag3 = false;
                                break;
                            }
                            default:
                                System.out.println("Invalid choice.");
                        }
                    }
                }
                case 4: {
                    flag = false;
                    break;
                }
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}