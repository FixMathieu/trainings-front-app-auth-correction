package fr.fms.api.trainings.entities;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Training implements Serializable {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private double price;
    private int quantity;
    @ManyToOne
    private  Category category;



}
