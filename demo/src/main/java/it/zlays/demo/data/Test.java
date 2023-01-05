package it.zlays.demo.data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Test {
    private Long id;

    @Id
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
