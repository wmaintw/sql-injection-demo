package mymvc.domain;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Audit {
    @Id
    @GeneratedValue
    @Column(name = "audit_id")
    private int id;
    @Temporal(TemporalType.TIMESTAMP)
    private Date actionDate;
    private String operation;
    @ManyToOne()
    @JoinColumn(name = "user_id")
    private User user;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getActionDate() {
        return actionDate;
    }

    public void setActionDate(Date actionDate) {
        this.actionDate = actionDate;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
