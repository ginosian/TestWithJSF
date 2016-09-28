package validator;

import util.MUtil;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
import java.util.Date;

/**
 * Created by marta.ginosyan on 9/28/2016.
 */
@FacesValidator("BirthdayValidator")
public class BirthdayValidator implements Validator{

    private String errorMessage;

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
        if(dataIsEmpty(o)) errorMessage = ErrorTypes.EMPTY_BIRTHDAY_DATE;
        if(dataIsInvalid(o)) errorMessage =  ErrorTypes.INVALID_BIRTHDAY_DATE;
        return errorMessage == null;
    }

    private boolean dataIsEmpty(Object o){
        return o == null || !(o instanceof Date);
    }

    private boolean dataIsInvalid(Object o){
        return !MUtil.isBeforeToday((Date) o);
    }
}
