package ru.marinin.zaklRequest.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Request {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private long internalNumber;
    private String factoryName;
    private String personData;
    private String email;
    private String type;
    private String vehicleType;
    private String category;
    private String description;
    private String dateTime;
    private String expertInfo;
}