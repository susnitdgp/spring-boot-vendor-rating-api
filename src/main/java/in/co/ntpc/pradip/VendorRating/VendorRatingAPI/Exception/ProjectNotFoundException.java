package in.co.ntpc.pradip.VendorRating.VendorRatingAPI.Exception;

public class ProjectNotFoundException extends RuntimeException{
    private String message;

    private static final long serialVersionUID = 1L;

    public ProjectNotFoundException(String message) {
        super(message);
        this.message = message;
    }
    public ProjectNotFoundException() {
        super("N/A");
        this.message="N/A";
    }

}
