package entity;

import java.util.Date;

/**
 * Created by marta.ginosyan on 9/29/2016.
 */
public class EmployeeDTO {

    private long id;
    private String name;
    private Date birthDate = new Date();
    private String position;

    public EmployeeDTO() {
    }

    public EmployeeDTO(long id, String name, Date birthDate, String position) {
        this.id = id;
        this.name = name;
        this.birthDate = birthDate;
        this.position = position;
    }

    public EmployeeDTO(String name, Date birthDate, String position) {
        this.name = name;
        this.birthDate = birthDate;
        this.position = position;
    }

    public EmployeeDTO(String name, Date birthDate) {
        this.name = name;
        this.birthDate = birthDate;
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
