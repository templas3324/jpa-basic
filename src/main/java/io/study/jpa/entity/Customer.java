package io.study.jpa.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Table(name = "customer_tb")
@ToString
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Customer {

    @Id
    private String id;
    private String name;
    private long registerDate;

    public Customer(String id, String name){
        this.id = id;
        this.name = name;
        this.registerDate = System.currentTimeMillis();
    }

    public static Customer sample(){
        return new Customer("ID0002", "Park");
    }
}
