package com.rentalhive.rentalhive.model;
import javax.persistence.*;
@Table(name = "reservations")
@Entity
public class Resevration {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "id_equipment")
     @ManyToOne
    private Equipment equipment;

    @Column(name = "id_client")
    @ManyToOne

    private User client;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Equipment getEquipment() {
        return equipment;
    }

    public void setEquipment(Equipment equipment) {
        this.equipment = equipment;
    }

    public User getClient() {
        return client;
    }

    public void setClient(User client) {
        this.client = client;
    }
}