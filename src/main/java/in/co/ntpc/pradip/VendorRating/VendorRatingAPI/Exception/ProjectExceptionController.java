package in.co.ntpc.pradip.VendorRating.VendorRatingAPI.Exception;


import in.co.ntpc.pradip.VendorRating.VendorRatingAPI.Model.ErrorObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Date;

@ControllerAdvice
public class ProjectExceptionController {

    @ExceptionHandler({ ProjectNotFoundException.class })
    public ResponseEntity<Object> exceptionHandler1(ProjectNotFoundException exception) {
        return new ResponseEntity<>("Error:"+exception.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler({ InsertException.class })
    public ResponseEntity<ErrorObject> exceptionHandler2(InsertException exception) {
        ErrorObject object=new ErrorObject();
        object.setError(exception.getMessage());
        object.setErrortype("CUSTOM");
        object.setErrortime(new Date().toString());
        return new ResponseEntity<ErrorObject>(object, HttpStatus.OK);
    }
}
