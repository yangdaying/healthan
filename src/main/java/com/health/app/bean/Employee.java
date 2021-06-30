package com.health.app.bean;

import lombok.*;

import javax.persistence.*;

@Entity
@Data
@Table(name = "user_employee",uniqueConstraints ={@UniqueConstraint(columnNames = "name")} )
@NoArgsConstructor
public class Employee {

    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String userName;

    @Column(name = "role")
    private String userRole;

    public Employee(String name,String role){
        this.userName = name;
        this.userRole = role;
    }


}
