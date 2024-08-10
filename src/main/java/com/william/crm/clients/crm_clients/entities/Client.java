package com.william.crm.clients.crm_clients.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="client")
public class Client {

    @Id
    @Column(name="idClient")    //spring.jpa.hibernate.naming.physical-strategy=org.hibernate.boot.model.naming.PhysicalNamingStrategyStandardImpl no convierte a id_client
    String id;

    @NotBlank(message="Name {NotBlank}")
    @Size(min=0, max=200, message="name {Size} 200")
    String name;

    @Email(message="{Email}")
    String email;

    @NotBlank(message="cellphone {NotBlank}")
    @Size(min=0, max=200, message="cellphone {Size} 10")
    String cellPhone;

    @NotBlank(message="Compnay {NotBlank}")
    @Size(min=0, max=200, message="company {Size} 200")
    String company;

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

    public String getCellPhone() {
        return cellPhone;
    }

    public void setCellPhone(String cellPhone) {
        this.cellPhone = cellPhone;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    
}
