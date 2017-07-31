package io.egen.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import java.util.UUID;

@Entity
public class Wind
{

    @Id
    @JoinColumn(columnDefinition = "VARCHAR(36)")
    private String wid;
    private float speed;
    private int degree;

    public Wind() {
        this.wid = UUID.randomUUID().toString();
    }
    public String getWid() {
        return wid;
    }

    public float getSpeed() {
        return speed;
    }

    public void setSpeed(float speed) {
        this.speed = speed;
    }

    public int getDegree() {
        return degree;
    }

    public void setDegree(int degree) {
        this.degree = degree;
    }



    @Override
    public String toString() {
        return "Wind{" +
                "wid='" + wid + '\'' +
                ", speed=" + speed +
                ", degree=" + degree +
                '}';
    }
}

