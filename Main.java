package com.company;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        EmployeeNamePrinter namePrinter = new EmployeeNamePrinter();
        EmployeeSalaryPrinter salaryPrinter = new EmployeeSalaryPrinter();

        //[1] [2] [3] [4] [5] = ArrayList
//         List<Employee> employeeList = new ArrayList<>();
//        addToList(new Employee("Sasha", "Petrov", 30, TEAM.AQA, POSITION.JUNIOR), employeeList);
//        addToList(new Employee("Igor", "Astakhov", 45, TEAM.Developer, POSITION.SENIOR), employeeList);
//        addToList(new Employee("Taras", "Sheva", 38, TEAM.MQA, POSITION.MIDDLE), employeeList);
//        addToList(new Employee("Ivan", "Ivanov", 25, TEAM.Developer, 1500, POSITION.JUNIOR), employeeList);
//        addToList(new Employee("Ivan", "Ivanov", 25, TEAM.AQA, 2500, POSITION.MIDDLE), employeeList);
//
//        for (Employee employee : employeeList){
//            namePrinter.print(employee);
//            salaryPrinter.print(employee);
//            System.out.println("_____________________");
//        }
 //[1]<->[2]<->[3]<->[7]<->[4]<->[5]<->[6] = LinkedList
        List<Employee> employeeLinkedList = new LinkedList<>();
        addToList(new Employee("Sasha", "Petrov", 30, TEAM.MQA, POSITION.JUNIOR), employeeLinkedList);
        addToList(new Employee("Igor", "Astakhov", 45, TEAM.Developer, POSITION.SENIOR), employeeLinkedList);
        addToList(new Employee("Taras", "Shevchenko", 38, TEAM.AQA, POSITION.MIDDLE), employeeLinkedList);
        addToList(new Employee("Ivan", "Ivanov", 25, TEAM.Developer, 1500, POSITION.JUNIOR), employeeLinkedList);
        addToList(new Employee("Taras", "Shevchenko", 38, TEAM.MQA, POSITION.MIDDLE), employeeLinkedList);
        addToList(new Employee("Vasyl", "Ivanov", 25, TEAM.Developer, 2500, POSITION.SENIOR_VIP), employeeLinkedList);

//Delete employee Ivan Ivanov
        for (Employee employee : employeeLinkedList) {
            if (employee.firstName.equals("Ivan") && employee.lastName.equals("Ivanov")){
                employeeLinkedList.remove(employee);
            }
        }
//Count of employee's  position
        int juniorCount=0;
        int middleCount=0;
        int seniorCount=0;
        int vipCount=0;
        for (Employee employee : employeeLinkedList){
            if (employee.position == POSITION.JUNIOR){juniorCount++;}else
            if (employee.position == POSITION.MIDDLE){middleCount++;}else
            if (employee.position == POSITION.SENIOR){seniorCount++;}else
            if (employee.position == POSITION.SENIOR_VIP){vipCount++;}
        }
        System.out.println("__________________________");
        System.out.println("Junior counts "+ juniorCount);
        System.out.println("Middle counts "+ middleCount);
        System.out.println("Senior counts "+ seniorCount);
        System.out.println("VIP counts "+ vipCount);

// Count of employee's positions with *MAP*
        Map<POSITION, Integer> counter = new HashMap<>();
        for (Employee employee : employeeLinkedList){
        if (!counter.containsKey(employee.position))
            counter.put(employee.position, 1);
            else{counter.put(employee.position, counter.get(employee.position)+1);}
        }
        System.out.println("_____________________");
        for (Map.Entry<POSITION, Integer> entry : counter.entrySet()){
            System.out.println("POSITION: "+ entry.getKey() + " counts " + entry.getValue());
        }
        System.out.println("_____________________");
        counter.remove(POSITION.SENIOR_VIP); // delete position from result
        System.out.println("SENIOR_VIP_after_DELETE : " + counter.get(POSITION.SENIOR_VIP));
        System.out.println("_____________________");
//Count Team With MAP
        Map<TEAM, Integer> teamCounter = new HashMap<>();
        for (Employee employee : employeeLinkedList){
            if (!teamCounter.containsKey(employee.team))
                teamCounter.put(employee.team, 1);
            else{teamCounter.put(employee.team, teamCounter.get(employee.team)+1);}
        }

        for (Map.Entry<TEAM, Integer> entry : teamCounter.entrySet()){
            System.out.println("Team: "+ entry.getKey() + " counts " + entry.getValue());
        }
        System.out.println("_____________________");
//Print Linked List
        for (Employee employee : employeeLinkedList){
            namePrinter.print(employee);
            salaryPrinter.print(employee);
            System.out.println("_____________________");
        }
    }
//Delete Duplicate employee
    public static void addToList(Employee employee, List<Employee> employeeList){
        if (!employeeList.contains(employee))
        employeeList.add(employee);
        else {
            System.out.println("===========================");
            System.out.println("Duplicate employee : " + employee.firstName+ " " + employee.lastName);
        }
    }
}
