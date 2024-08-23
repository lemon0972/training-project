package org.example;

import com.mongodb.client.*;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
import org.bson.Document;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.mongodb.client.model.Filters.*;

public class Main {
    private static MongoClient mongoClient;
    private static MongoDatabase database;
    private static MongoCollection<Document> collection;
    public static void main(String[] args) {
        String connectionString = "mongodb+srv://lemon:lemon@cluster0.c7y8y.mongodb.net/?retryWrites=true&w=majority&appName=Cluster0";
        mongoClient = MongoClients.create(connectionString);
        database = mongoClient.getDatabase("mydatabase");
        collection = database.getCollection("users");

        Scanner scanner = new Scanner(System.in);
        boolean run = true;

        while(run){
            System.out.println("\n===== MENU =====");
            System.out.println("1. Them nguoi dung");
            System.out.println("2. Hien thi tat ca nguoi dung");
            System.out.println("3. Cap nhat thong tin nguoi dung");
            System.out.println("4. Xoa nguoi dung");
            System.out.println("5. Thoat");
            System.out.print("Chon: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    addUser(scanner);
                    break;
                case 2:
                    readUser();
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
                    System.out.println("Lua chon khong hop le vui long chon lai!");
            }
        }
        mongoClient.close();
    }
    public static void addUser(Scanner scanner){
        System.out.println("Nhap ten: ");
        String name = scanner.nextLine();

        System.out.println("Nhap tuoi: ");
        int age = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Nhap email: ");
        String email = scanner.next();

        if(!isValidEmail(email)){
            System.out.println("Email nhap khong dung dinh dang, vui long nhap lai.");
            return;
        }

        Document user = new Document("name", name).append("age", age).append("email", email);
        collection.insertOne(user);
        System.out.println("Them nguoi dung thanh cong");
    }
    public static void readUser(){
        System.out.println("Danh sach nguoi dung");
        for(Document doc : collection.find()){
            System.out.println(doc.toJson());
        }
    }
    public static void updateUser(Scanner scanner){
        System.out.println("Nhap ten nguoi dung can cap nhat: ");
        String name = scanner.nextLine();

        Document existingUser = collection.find(Filters.eq("name", name)).first();
        if(existingUser == null){
            System.out.println("Ten nguoi dung khong ton tai. Vui long kiem tra lai");
            return;
        }

        System.out.println("Nhap tuoi moi: ");
        int newAge = scanner.nextInt();

        System.out.println("Nhap email moi:");
        String newEmail = scanner.nextLine();

        if(!isValidEmail(newEmail)){
            System.out.println("Email nhap khong dung dinh dang, vui long nhap lai.");
            return;
        }

        collection.updateOne(Filters.eq("name", name), Updates.combine(Updates.set("age", newAge), Updates.set("email", newEmail)));
        System.out.println("Cap nhat nguoi dung thanh cong!");
    }
    public static void deleteUser(Scanner scanner){
        System.out.println("Nhap ten nguoi dung can xoa: ");
        String name = scanner.nextLine();

        Document existingUser = collection.find(Filters.eq("name", name)).first();
        if(existingUser == null){
            System.out.println("Ten nguoi dung khong ton tai. Vui long kiem tra lai");
            return;
        }

        collection.deleteOne(Filters.eq("name",name));
        System.out.println("Xoa nguoi dung thanh cong!");
    }
    public static boolean isValidEmail(String email) {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        Pattern pattern = Pattern.compile(emailRegex);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }
}

