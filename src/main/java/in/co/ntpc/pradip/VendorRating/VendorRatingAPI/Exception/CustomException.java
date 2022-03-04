package in.co.ntpc.pradip.VendorRating.VendorRatingAPI.Exception;

public class CustomException extends RuntimeException {

    private String message;
    private static final long serialVersionUID = 1L;

    public CustomException(String message){
        super(message);
        this.message=message;
    }

}
