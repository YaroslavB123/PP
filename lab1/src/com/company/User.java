package com.company;

public class User {
    private String firstName;
    private String lastName;
    private int age;
    private String email;

    public User(final String firstName, final String lastName, final int age, final String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.email = email;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o)
            return true;
        if (this.getClass() != o.getClass())
            return false;
        final User that = (User) o;
        return age == that.age && firstName.equals(that.firstName)
                && lastName.equals(that.lastName)
                && email.equals(that.email);
    }

    @Override
    public int hashCode() {
        final int result = (firstName.hashCode() + lastName.hashCode() + email.hashCode() + age);
        return result;
    }

    public static void main(final String[] args) {
        final User task1 = new User("Denys", "Mars", 20, "denys@gmail.com");
        final User task = new User("Denys", "Mars", 20, "denys@gmail.com");

        if (task1.hashCode() == task.hashCode() && task1.equals(task)) {
            System.out.print("Rivno");
        } else {
            System.out.print("NE rivno");
        }
    }
}
