package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;
        boolean run = true;

        while (run){
            System.out.println("\n=====MENU=====");
            System.out.println("1. Them nguoi dung");
            System.out.println("2. Hien thi nguoi dung");
            System.out.println("3. Cap nhat nguoi dung");
            System.out.println("4. Xoa nguoi dung");
            System.out.println("5. Thoat");
            System.out.println("Chon: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice){
                case 1:
                    createUser(scanner);
                    break;
                case 2:
                    UserCRUD.readUsers();
                    break;
                case 3:
                    updateUser(scanner);
                    break;
                case 4:
                    deleteUser(scanner);
                    break;
                case 5:
                    run = false;
                    break;
                default:
                    System.out.println("Lua chon khong hop le, Vui long chon lai!");
            }
        }
        scanner.close();
    }
    private static void createUser(Scanner scanner) {
        System.out.print("Nhap ten: ");
        String name = scanner.nextLine();

        System.out.print("Nhap email: ");
        String email = scanner.next();

        while (!UserCRUD.isValidEmail(email)) {
            System.out.println("Email khong dung dinh dang, vui long nhap lai!.");
            System.out.print("Nhap email: ");
            email = scanner.next();
        }

        System.out.print("Nhap tuoi: ");
        int age = scanner.nextInt();

        UserCRUD.createUser(name, email, age);
    }
    private static void updateUser(Scanner scanner) {
        System.out.print("Nhap ten nguoi dung muon cap nhat: ");
        String currentName = scanner.nextLine();

        if(!UserCRUD.doesUserExist(currentName)){
            System.out.println("Nguoi dung voi ten " + currentName + "khong ton tai!");
            return;
        }
        System.out.println("Nhap ten moi:");
        String newName = scanner.nextLine();

        System.out.print("Nhap email moi: ");
        String newEmail = scanner.next();

        while (!UserCRUD.isValidEmail(newEmail)) {
            System.out.println("Email sai dinh dang, vui long nhap lai!.");
            System.out.print("Nhap email: ");
            newEmail = scanner.next();
        }

        System.out.print("Nhap tuoi moi: ");
        int newAge = scanner.nextInt();
        scanner.nextLine();

        UserCRUD.updateUser(currentName, newName, newEmail, newAge);
    }

    private static void deleteUser(Scanner scanner) {
        System.out.print("Nhap ten nguoi dung muon xoa: ");
        String name = scanner.nextLine();

        UserCRUD.deleteUser(name);
    }
}