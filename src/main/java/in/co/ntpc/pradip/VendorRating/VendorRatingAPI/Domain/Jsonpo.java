package in.co.ntpc.pradip.VendorRating.VendorRatingAPI.Domain;



import com.ibm.db2.jcc.uw.Blob;

import javax.persistence.*;

@Entity
@Table(name="VENDOR_RATING.JSONPO")
public class Jsonpo {

    @Id
    @Column(name="ID")
    private int ID;

    @Column(name="DATA")
    private byte[] data;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public byte[] getData() {
        return data;
    }

    public void setData(byte[] data) {
        this.data = data;
    }
}
