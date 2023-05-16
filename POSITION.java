package com.company;

public enum POSITION {
    JUNIOR(500), // 0
    MIDDLE(2000), // 1
    SENIOR(5000), // 2
    SENIOR_VIP(10000); // 3

    public final int minSalary;

     POSITION (int minSalary){
         this.minSalary = minSalary;
     }
}
