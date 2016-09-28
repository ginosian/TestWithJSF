package validator;

import db.DBImitation;
import util.MUtil;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

/**
 * Created by marta.ginosyan on 9/28/2016.
 */
@FacesValidator("EmployeeNameValidator")
public class EmployeeNameValidator implements Validator{

    private String errorMessage;

    @Override
    public void validate(FacesContext facesContext, UIComponent uiComponent, Object o) throws ValidatorException {
        if (!validationPassed(o)) validationError(errorMessage);
    }

    private void validationError(String message) {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, message, message);
        facesContext.addMessage(null, msg);
        throw new ValidatorException(msg);
    }

    private boolean validationPassed(Object o){
        errorMessage = null;
        if(dataIsEmpty(o)) errorMessage = ErrorTypes.EMPTY_EMPLOYEE_NAME;
        if(dataIsInvalid(o)) errorMessage =  ErrorTypes.EMPLOYEE_NAME_EXIST;
        if(dataFormatIsInvalid(o)) errorMessage =  ErrorTypes.NOT_ALPHABETIC_EMPLOYEE_NAME;
        return errorMessage == null;
    }

    private boolean dataIsEmpty(Object o){
        return !(o instanceof String) || MUtil.invalidString((String)o);
    }

    private boolean dataIsInvalid(Object o){
        return DBImitation.getInstance().dataExist((String) o);
    }

    private boolean dataFormatIsInvalid(Object o){
        return !MUtil.isAlphabeticData((String) o);
    }
}
