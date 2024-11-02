package ru.marinin.zaklRequest.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.marinin.zaklRequest.repository.RequestRepository;

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

    public Request(long internalNumber, String factoryName, String personData, String email, String type, String vehicleType, String category, String description, String dateTime, String expertInfo) {
        this.internalNumber = internalNumber;
        this.factoryName = factoryName;
        this.personData = personData;
        this.email = email;
        this.type = type;
        this.vehicleType = vehicleType;
        this.category = category;
        this.description = description;
        this.dateTime = dateTime;
        this.expertInfo = expertInfo;
    }
}