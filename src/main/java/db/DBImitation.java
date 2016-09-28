package db;

import entity.EmployeeDataBean;

import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by marta.ginosyan on 9/27/2016.
 */
public class DBImitation {
    private static DBImitation instance = new DBImitation();
    private static long id;

    private static boolean defaultsAreSet;
    private static List<EmployeeDataBean> employees = new LinkedList<>();
    private static List<String> employeesNames = new LinkedList<>();
    private static HashMap<String, EmployeeDataBean> nameEntityPairs = new HashMap<>();

    public static DBImitation getInstance() {
        if(!defaultsAreSet){
            EmployeeDataBean employee1 = new EmployeeDataBean("DefaultName1", new Date(11111));
            EmployeeDataBean employee2 = new EmployeeDataBean("DefaultName2", new Date(22222));

            employee1.setId(instance.generateId());
            employee2.setId(instance.generateId());

            employees.add(employee1);
            employees.add(employee2);

            employeesNames.add("DefaultName1");
            employeesNames.add("DefaultName2");

            nameEntityPairs.put(employee1.getName(), employee1);
            nameEntityPairs.put(employee2.getName(), employee2);

            defaultsAreSet = true;
        }
        return instance;
    }

    private DBImitation() {
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

    public void updatePosition (String employeeName, String position){
        EmployeeDataBean employee = nameEntityPairs.get(employeeName);
        employee.setPosition(position);
        nameEntityPairs.replace(employeeName, employee);
    }

    public HashMap<String, EmployeeDataBean> getNameEntityPairs() {
        return nameEntityPairs;
    }
}
