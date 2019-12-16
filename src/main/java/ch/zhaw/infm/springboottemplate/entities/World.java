package ch.zhaw.infm.springboottemplate.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.io.Serializable;


@Entity
public class World implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long worldId;

    @NotNull
    private String name;

    // Bewohnbar?
    private Boolean habitable;

    public World() {
    }

    public World(@NotNull String name, Boolean habitable) {
        this.name = name;
        this.habitable = habitable;
    }

    // GETTER und SETTER
    public Long getWorldId() {
        return worldId;
    }

    private void setWorldId(Long worldId) {
        this.worldId = worldId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getHabitable() {
        return habitable;
    }

    public void setHabitable(Boolean habitable) {
        this.habitable = habitable;
    }

}
