package dev07;

import lombok.*;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Employee {
    private int id;
    private String name;
    private int age;
    double salary;

}
