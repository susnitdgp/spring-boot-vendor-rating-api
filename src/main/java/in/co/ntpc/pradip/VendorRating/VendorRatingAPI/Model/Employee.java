
package in.co.ntpc.pradip.VendorRating.VendorRatingAPI.Model;


public class Employee {

    private String  key;
    private String name;
    private String role;
    private String dept;
    private String plant;

    public Employee() {}

    public Employee(String name, String role) {

      this.name = name;
      this.role = role;
    }

    public String getKey(){
        return this.key;
    }

    public void setKey(String key){
      this.key=key;
    }
    public String getName() {
      return this.name;
    }

    public String getRole() {
      return this.role;
    }

    public void setName(String name) {
      this.name = name;
    }

    public void setRole(String role) {
      this.role = role;
    }

    public String getDept(){
        return this.dept;
    }

    public String getPlant(){
      return this.dept;
    }
    public void setDept(String dept){
          this.dept=dept;
      }

    public void setPlant(String plant){
        this.plant=plant;
    }
 

}