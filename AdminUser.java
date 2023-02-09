import java.util.ArrayList;
import java.util.Date;

public class AdminUser extends User implements HIPAACompliantAdmin, HIPAACompliantUser {
  // imports class definition
  // Inside class:

  private String role;
  private ArrayList<String> securityIncidents;

  // TO DO: Implement a constructor that takes an ID and a role
  public AdminUser(Integer id, String role) {
    super(id);
    this.role = role;
    // TODO Auto-generated constructor stub
  }

  // TO DO: Implement HIPAACompliantUser!
  // TO DO: Implement HIPAACompliantAdmin!

  public void newIncident(String notes) {
    String report = String.format(
        "Datetime Submitted: %s \n,  Reported By ID: %s\n Notes: %s \n",
        new Date(), this.id, notes);
    securityIncidents.add(report);
  }

  public void authIncident() {
    String report = String.format(
        "Datetime Submitted: %s \n,  ID: %s\n Notes: %s \n",
        new Date(), this.id, "AUTHORIZATION ATTEMPT FAILED FOR THIS USER");
    securityIncidents.add(report);
  }

  @Override
  public boolean assignPin(int pin) {
    if (String.valueOf(pin).length() < 6) {
      return false;
    }
    return true;
  }

  @Override
  public boolean accessAuthorized(Integer confirmedAuthID) {
    if (confirmedAuthID.equals(this.id)) {

      return true;
    } else {
      
      return false;
    }
  }

  @Override
  public ArrayList<String> reportSecurityIncidents() {
    
    return securityIncidents;
  }
}
