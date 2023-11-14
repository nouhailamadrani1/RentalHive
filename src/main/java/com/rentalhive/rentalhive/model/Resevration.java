package com.rentalhive.rentalhive.model;
import javax.persistence.*;
import java.util.Date;

@Table(name = "reservations")
@Entity
public class Resevration {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private Date end_date;
    private Date start_date;
    @Column(name = "id_equipment")
     @ManyToOne
    private Equipment equipment;

    @Column(name = "id_client")
    @ManyToOne

    private User client;

    public Date getEnd_date() {
        return end_date;
    }

    public void setEnd_date(Date end_date) {
        this.end_date = end_date;
    }

    public Date getStart_date() {
        return start_date;
    }

    public void setStart_date(Date start_date) {
        this.start_date = start_date;
    }

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