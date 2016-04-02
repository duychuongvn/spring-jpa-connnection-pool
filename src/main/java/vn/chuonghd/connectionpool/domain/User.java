package vn.chuonghd.connectionpool.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;

/**
 * Created by huynhduychuong on 4/1/2016.
 */
@Entity
@Table(name = "user")
public class User {


    @Id
    private String id = UUID.randomUUID().toString();

    @Column
    private String name;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
