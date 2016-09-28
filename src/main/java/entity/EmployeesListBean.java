package entity;

import db.DBImitation;

import javax.faces.bean.ManagedBean;
import java.util.List;

/**
 * Created by marta.ginosyan on 9/27/2016.
 */
@ManagedBean(name = "list")
public class EmployeesListBean {

    public List<EmployeeDataBean> getBirthdays() {
        return DBImitation.getInstance().getBirthdays();
    }


}
