package cz.uhk.fim.dms.repository.entity;

import javax.persistence.*;

@Entity
@Table(name ="category")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
}
