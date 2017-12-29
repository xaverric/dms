package cz.uhk.fim.repository.entity;

import java.util.List;
import javax.persistence.*;

@Entity
@Table(name = "label")
public class Label{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @Column(nullable = false)
    private String name;
    
    @ManyToMany(mappedBy = "labels")
    private List<File> files;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<File> getFiles() {
        return files;
    }

    public void setFiles(List<File> files) {
        this.files = files;
    }
    
    

    @Override
    public String toString() {
        return "Label{" + "id=" + id + ", name=" + name + '}';
    }
    
    
}
