package validator;

/**
 * Created by marta.ginosyan on 9/28/2016.
 */
public class ErrorTypes {

    // region New employee name
    public static String EMPTY_EMPLOYEE_NAME = "No name entered";
    public static String EMPLOYEE_NAME_EXIST = "Employee already exist";
    public static String NOT_ALPHABETIC_EMPLOYEE_NAME = "Employee name should consist of alphabetic symbols";
    // endregion

    // region Employee birthday date
    public static String INVALID_BIRTHDAY_DATE = "Birthday date should be before current date";
    public static String EMPTY_BIRTHDAY_DATE = "No birthday date added";
    // endregion
}
