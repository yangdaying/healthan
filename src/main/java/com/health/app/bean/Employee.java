package com.health.app.bean;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sun.xml.internal.ws.developer.Serialization;
import lombok.*;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Serialization
@Table(name = "user_employee",uniqueConstraints ={@UniqueConstraint(columnNames = "name")} )
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
