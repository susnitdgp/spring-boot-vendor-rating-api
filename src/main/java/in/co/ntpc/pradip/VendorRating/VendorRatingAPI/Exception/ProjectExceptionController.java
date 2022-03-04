package in.co.ntpc.pradip.VendorRating.VendorRatingAPI.Exception;


import in.co.ntpc.pradip.VendorRating.VendorRatingAPI.Model.ErrorObject;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;

@ControllerAdvice
public class ProjectExceptionController {

   // @ExceptionHandler({ CustomException.class })
    //public ResponseEntity<Object> exceptionHandler1(CustomException exception) {
   //     return new ResponseEntity<>("Error:"+exception.getMessage(), HttpStatus.NOT_FOUND);
   // }

    @ExceptionHandler({ CustomException.class})
    public ResponseEntity<ErrorObject> exceptionHandler(CustomException exception,
                                                         WebRequest request) {
        ErrorObject object=new ErrorObject();

        object.setError(exception.getMessage());
        object.setErrortype("CUSTOM : " + request.getContextPath());
        object.setErrortime(new Date().toString());
        return new ResponseEntity<ErrorObject>(object, HttpStatus.OK);
    }
}
