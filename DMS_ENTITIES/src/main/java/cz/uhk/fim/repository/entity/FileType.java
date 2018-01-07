package cz.uhk.fim.repository.entity;

import javax.persistence.*;

@Entity
@Table(name = "file_type")
public class FileType {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private String suffix;

    private String description;

    private String fileTypeCategory;

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

    public String getSuffix() {
        return suffix;
    }

    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getFileTypeCategory() {
        return fileTypeCategory;
    }

    public void setFileTypeCategory(String fileTypeCategory) {
        this.fileTypeCategory = fileTypeCategory;
    }

    @Override
    public String toString() {
        return "FileType{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", suffix='" + suffix + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
