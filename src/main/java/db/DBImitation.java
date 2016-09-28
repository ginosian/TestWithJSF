package db;

import entity.EmployeeDataBean;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by marta.ginosyan on 9/27/2016.
 */
public class DBImitation {
    private static boolean defaultDataIsSet;
    private static DBImitation instance = new DBImitation();
    private static long id;

    private static List<EmployeeDataBean> employees = new LinkedList<>();
    private List<String> employeesNames = new LinkedList<>();

    public static DBImitation getInstance() {
        if(!defaultDataIsSet){
            employees.add(new EmployeeDataBean("DefaultName1", new Date(11111)));
            employees.add(new EmployeeDataBean("DefaultName2", new Date(22222)));
            defaultDataIsSet = true;
        }
        return instance;
    }

    private DBImitation() {
        employeesNames.add("DefaultName1");
        employeesNames.add("DefaultName2");
    }


    public List<EmployeeDataBean> getBirthdays() {
        return employees;
    }

    public void addRecord(EmployeeDataBean record){
        employeesNames.add(record.getName());
        employees.add(record);
    }

    public long generateId(){
        return ++id;
    }

    public boolean dataExist(String name){
        return employeesNames.contains(name);
    }

    public List<String> getEmployeesNames() {
        return employeesNames;
    }
}
