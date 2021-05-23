package com.company;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.*;


public class LoginForm {
    public static Connection conn;
    public static Statement statmt;
    public static ResultSet resSet;

    public static void main(String[] args) throws IOException, SQLException, ClassNotFoundException, NoSuchAlgorithmException {
        connect();
        add("Diana", "DianaShreder18052001");
        System.out.println(check("Diana", "DianaShreder18052001"));
        System.out.println(check("Diana", "DianaShreder19052001"));
        close();
    }

    public static void add(String login, String password) throws SQLException, NoSuchAlgorithmException {
        //шифрование пароля
        password = hash(password);
        //проверяем занят ли данный логин(желательно обработать, чтоб что-то возвращало)
        if (!isExist(login))
            //если логин не занят - добавляем
            statmt.execute("INSERT INTO my_table  VALUES ('" + login + "', '" + password + "'); ");
    }

    public static boolean check(String login, String password) throws SQLException, NoSuchAlgorithmException {
        //шифрование пароля
        password = hash(password);

        resSet = statmt.executeQuery("SELECT * FROM my_table where login ='" + login + "'");
        if (resSet != null) {
            if (resSet.getString("password").equals(password)) return true;
            else return false;
        } else return false;
    }

    public static boolean isExist(String login) throws SQLException {
        resSet = statmt.executeQuery("SELECT * FROM my_table where login ='" + login + "'");
        if (resSet != null) return true;
        else return false;
    }

    public static void connect() throws ClassNotFoundException, SQLException {
        //коннект к базе
        conn = null;
        Class.forName("org.sqlite.JDBC");
        conn = DriverManager.getConnection("jdbc:sqlite:identifier.sqlite");
        System.out.println("База Подключена!");
        statmt = conn.createStatement();
    }

    public static void close() throws SQLException {
        conn.close();
        statmt.close();
        resSet.close();
    }

    private static String hash(String password) throws NoSuchAlgorithmException {
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        byte[] encodedhash = digest.digest(
                password.getBytes(StandardCharsets.UTF_8));

        StringBuilder hexString = new StringBuilder(2 * encodedhash.length);
        for (int i = 0; i < encodedhash.length; i++) {
            String hex = Integer.toHexString(0xff & encodedhash[i]);
            if (hex.length() == 1) {
                hexString.append('0');
            }
            hexString.append(hex);
        }
        return hexString.toString();
    }
}
