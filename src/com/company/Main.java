package com.company;


import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.function.Predicate;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
        Main main = new Main();
        main.run();

    }

    private void run() {
        List<String> names = Arrays.asList("Zosia","Franek","Kasia","Marcin","Tomek","Ola","Tola","Marcel", "Kasztan", "Barbara", "Jacek");

        names.stream()
                .filter(s -> s.endsWith("a"))
                .forEach(System.out::println);

        List<String>womenNames = names.stream()
                .filter(s -> s.endsWith("a"))
                .collect(Collectors.toList());
        System.out.println(womenNames);

        List <User> userlist = names.stream()
                .filter(n -> n.endsWith("a"))
                .map(string -> new User(string, new Random().nextInt(60)))
                .collect(Collectors.toList());
        System.out.println(userlist);

        List <User> userListCompared = names.stream()
                .filter(n -> n.endsWith("a"))
                .map(string -> new User(string, new Random().nextInt(60)))
                .sorted(Comparator.comparing(User::getName).reversed())//w nowej javie tworzenie nowego komparatora...
                //.sorted((o1, o2) -> o1.getName().compareTo(o2.getName()))
                .collect(Collectors.toList());
        System.out.println(userListCompared);
    }

    class User {
        private String name;
        private int age;

        public User(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }

        @Override
        public String toString() {
            return "User{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }
    }
}



