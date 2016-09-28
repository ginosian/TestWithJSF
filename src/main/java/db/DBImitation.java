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

    private static List<EmployeeDataBean> birthdays = new LinkedList<>();

    public static DBImitation getInstance() {
        if(!defaultDataIsSet){
            birthdays.add(new EmployeeDataBean("DefaultName1", new Date(11111)));
            birthdays.add(new EmployeeDataBean("DefaultName1", new Date(22222)));
            defaultDataIsSet = true;
        }
        return instance;
    }

    private DBImitation() {
    }


    public List<EmployeeDataBean> getBirthdays() {
        return birthdays;
    }

    public void addRecord(EmployeeDataBean record){
        birthdays.add(record);
    }

    public long generateId(){
        return ++id;
    }
}
