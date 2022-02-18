package in.co.ntpc.pradip.VendorRating.VendorRatingAPI.Domain;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="VENDOR_RATING.PROJECT_DETAILS")
public class ProjectDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID")
    private int ID;

    @Column(name="NAME")
    private String name;

    @Column(name="DESCRIPTION")
    private String description;

    @Column(name="START_DATE")
    private Date startdate;

    @Column(name="AMOUNT")
    private double amount;



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getStartdate() {
        return startdate;
    }

    public void setStartdate(Date startdate) {
        this.startdate = startdate;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }


    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }


}
