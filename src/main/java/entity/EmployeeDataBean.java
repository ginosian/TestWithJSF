package entity;

import db.DBImitation;

import javax.faces.bean.ManagedBean;
import java.util.Date;

/**
 * Created by marta.ginosyan on 9/27/2016.
 */
@ManagedBean(name = "employee")
public class EmployeeDataBean {

    private long id;
    private String name;
    private Date birthDate = new Date();
    private String position;


    public EmployeeDataBean() {
    }

    public EmployeeDataBean(String name, Date birthDate) {
        this.name = name;
        this.birthDate = birthDate;
    }

    public void addRecord() {
        this.id = DBImitation.getInstance().generateId();
         DBImitation.getInstance().addRecord(this);
    }

    public void updatePosition(String name, String position){
        DBImitation.getInstance().updatePosition(this.name, this.position);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

}
