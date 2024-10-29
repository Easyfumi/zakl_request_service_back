package ru.marinin.zaklRequest.model;


import lombok.Data;


import java.time.LocalDateTime;

@Data
public class Request {
    private final String factoryName;
    private final String personData;
    private final String email;
    private final String type;
    private final String vehicleType;
    private final String category;
    private final String pathToFileRequest;
    private final String pathToFileOTO;
    private final String description;
    private final LocalDateTime localDateTime;

    private Request(Builder builder) {
        this.factoryName = builder.factoryName;
        this.personData = builder.personData;
        this.email = builder.email;
        this.type = builder.type;
        this.vehicleType = builder.vehicleType;
        this.category = builder.category;
        this.pathToFileRequest = builder.pathToFileRequest;
        this.pathToFileOTO = builder.pathToFileOTO;
        this.description = builder.description;
        this.localDateTime = builder.localDateTime;
    }

    @Override
    public String toString() {
        return "Request{" +
                "factoryName='" + factoryName + '\'' +
                ", personData='" + personData + '\'' +
                ", email='" + email + '\'' +
                ", type='" + type + '\'' +
                ", vehicleType='" + vehicleType + '\'' +
                ", category='" + category + '\'' +
                ", pathToFileRequest='" + pathToFileRequest + '\'' +
                ", pathToFileOTO='" + pathToFileOTO + '\'' +
                ", description='" + description + '\'' +
                ", localDateTime=" + localDateTime +
                '}';
    }

    public static class Builder {
        private String factoryName;
        private String personData;
        private String email;
        private String type;
        private String vehicleType;
        private String category;
        private String pathToFileRequest;
        private String pathToFileOTO;
        private String description;
        private LocalDateTime localDateTime;

        public Builder factoryName(String factoryName) {
            this.factoryName = factoryName;
            return this;
        }

        public Builder personData(String personData) {
            this.personData = personData;
            return this;
        }

        public Builder email(String email) {
            this.email = email;
            return this;
        }

        public Builder type(String type) {
            this.type = type;
            return this;
        }

        public Builder vehicleType(String vehicleType) {
            this.vehicleType = vehicleType;
            return this;
        }

        public Builder category(String category) {
            this.category = category;
            return this;
        }

        public Builder pathToFileRequest(String pathToFileRequest) {
            this.pathToFileRequest = pathToFileRequest;
            return this;
        }

        public Builder pathToFileOTO(String pathToFileOTO) {
            this.pathToFileOTO = pathToFileOTO;
            return this;
        }

        public Builder description(String description) {
            this.description = description;
            return this;
        }

        private Builder localDateTime() {
            this.localDateTime = LocalDateTime.now();
            return this;
        }

        public Request build() {
            this.localDateTime();
            return new Request(this);
        }
    }


}
