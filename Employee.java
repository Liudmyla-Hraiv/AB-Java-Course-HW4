package com.company;

public class Employee {

    public String firstName; //имя
    public String lastName; //фамилия
    public int age; //возраст
    public TEAM team;  //команда
    public long salary; // зп
    public POSITION position; //позиция сотрудника

    public Employee (String firstName, String lastName, int age, TEAM team, POSITION position){
        this(firstName, lastName, age, team, 0, position);
    }
    public Employee (String firstName, String lastName, int age, TEAM team, long salary, POSITION position){

        if (age <18) {
            System.out.println("Incorrect age value");
        }

        this.firstName=firstName;
        this.lastName=lastName;
        this.age = age;
        this.team = team;
         if (salary == 0){
             salary = position.minSalary;
         }
         this.salary = salary;
        this.position = position;
    }
    public String toString(){
    return "Employee info: " + this.firstName + " " + this.lastName + " " + this.position.toString();
    }

    public boolean equals(Object obj){
        return obj instanceof Employee
                && ((Employee) obj).firstName.equals(this.firstName)
                && ((Employee) obj).lastName.equals(this.lastName);
    }
}
