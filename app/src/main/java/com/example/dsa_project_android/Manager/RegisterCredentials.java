package com.example.dsa_project_android.Manager;

public class RegisterCredentials {
        String username;
        String password;
        String name;
        String surname;
        String mail;
        int age;
        public RegisterCredentials(){}

        public RegisterCredentials(String username, String password, String name, String surname, String mail, int age) {
            this.username = username;
            this.password = password;
            this.name = name;
            this.surname = surname;
            this.mail = mail;
            this.age = age;
        }
}


