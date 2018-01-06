package cz.uhk.fim.repository.types.api;

public enum RoleType {

    ADMIN("administrator"),
    USER("user");

    private String description;

    RoleType(String description) {
        this.description = description;
    }

    public String getName(){
        return super.toString();
    }

    public String getDescription() {
        return description;
    }
}
