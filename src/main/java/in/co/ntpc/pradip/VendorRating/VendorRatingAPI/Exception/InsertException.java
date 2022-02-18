package in.co.ntpc.pradip.VendorRating.VendorRatingAPI.Exception;

public class InsertException extends RuntimeException{

    private String message;
    private static final long serialVersionUID = 1L;

    public InsertException(String message){
        super(message);
        this.message=message;
    }

}
