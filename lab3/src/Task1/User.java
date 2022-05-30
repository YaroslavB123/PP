package Task1;

import java.util.ArrayList;
import java.util.List;

public class User {
    String firstName;
    String surName;
    int age;
    Sex sex;
    Address address;

    public User(final String firstName, final String surname, final int age, final Sex sex, final Address address) {
        this.firstName = firstName;
        this.surName = surname;
        this.age = age;
        this.sex = sex;
        this.address = address;

        validate();
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(final String firstName) {
        this.firstName = firstName;
        validate();
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(final String surName) {
        this.surName = surName;
        validate();
    }

    public int getAge() {
        return age;
    }

    public void setAge(final int age) {
        this.age = age;
        validate();
    }

    public Sex getSex() {
        return sex;
    }

    public void setSex(final Sex sex) {
        this.sex = sex;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(final Address address) {
        this.address = address;
    }

    public void validate() {
        final List<String> list = new ArrayList<>();

        if(firstName.matches(".*\\d+.*") || firstName.matches(".*\\s+.*")|| !firstName.matches(".+")) {
            list.add("incorrectly firstname");
        }
        if(surName.matches(".*\\d+.*") || surName.matches(".*\\s+.*")|| !surName.matches(".+")) {
            list.add("incorrectly surname");
        }
        if(age<0) {
            list.add("incorrectly age");
        }

        if(!list.isEmpty()){
            ;
        }
    }
    @Override
    public String toString() {
        return "User {" +
                "firstname=' " + firstName + '\'' +
                ", surname=' " + surName + '\'' +
                ", age= " + age +
                ", sex= " + sex +
                ", address= " + address.getAddress() +
                '}';
    }
}
