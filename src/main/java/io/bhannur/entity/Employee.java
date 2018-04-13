package io.bhannur.entity;

import javax.persistence.*;
import java.util.UUID;

@Entity
@NamedQueries(
        {@NamedQuery(name = "Employee.findAll", query = "SELECT e FROM Employee e"),
        @NamedQuery(name = "Employee.findByEmail", query = "SELECT e FROM Employee e WHERE e.email =:pEmail")
        }
)
public class Employee {
    @Id
    private String id;
    private String name;
    private String city;
    private String salary;
    @Column(unique = true)
    private String email;

    public Employee()
    {
        this.id = UUID.randomUUID().toString();
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }


    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
