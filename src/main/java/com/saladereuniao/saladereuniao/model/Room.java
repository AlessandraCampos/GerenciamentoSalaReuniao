package com.saladereuniao.saladereuniao.model;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;


@Entity
@Table(name = "meetingroom")
public class Room {
    private long id;
    private String name;
    private String date;
    private String startHour;
    private String endHour;
    public Room(){

    }
    public Room(long id,String name,String date, String startHour, String endHour){
        this.id= id;
        this.date=date;
        this.startHour= startHour;
        this.endHour=endHour;
    }
@Id // chave da tabela
@GeneratedValue(strategy = GenerationType.AUTO)// será gerada automaticamente
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
@Column(name = "name",nullable = false) //Campo name , valor nao pode ser nulo
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
@Column(name = "date",nullable = false) //Campo data não pode ser nulo
    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
 @Column(name = "starthour",nullable = false)//Campo starthour não pode ser nulo
    public String getStartHour() {
        return startHour;
    }

    public void setStartHour(String startHour) {
        this.startHour = startHour;
    }
@Column(name = "endhour",nullable = false)//Campo endHour não pode ser nulo
    public String getEndHour() {
        return endHour;
    }

    public void setEndHour(String endHour) {
        this.endHour = endHour;
    }

public String toString(){
        return "Room [id="+id+ ",name"+name +"start Hour"+ startHour+"end hour"+ endHour+"]";
}


}
