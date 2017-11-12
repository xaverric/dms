package cz.uhk.fim.dms.repository.entity;

import javax.persistence.*;

@Entity
@Table(name = "file_type")
public class FileType {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
}
