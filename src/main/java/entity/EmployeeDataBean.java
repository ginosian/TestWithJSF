package entity;

import db.DBImitation;
import exception.InvalidDataException;
import util.MUtil;

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
        if(dataIsValid()) DBImitation.getInstance().addRecord(this);
        else throw new InvalidDataException("Input data is invalid, either name is empty or birth day is invalid");
    }

    public long getId() {
        return id;
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

    private boolean dataIsValid(){
        return name != null &&
                !name.isEmpty() &&
                birthDate != null &&
                birthDate.before(MUtil.getCurrentDate());
    }
}
