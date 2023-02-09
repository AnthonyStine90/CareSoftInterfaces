import java.util.ArrayList;
import java.util.Date;

public class Physician extends User implements HIPAACompliantUser {
  // ... imports class definition...

  // Inside class:
  private ArrayList<String> patientNotes;

  // TO DO: Constructor that takes an ID
  // TO DO: Implement HIPAACompliantUser!

  public Physician(Integer id) {
    super(id);
    // super invokes the superclass method in our own
  }

  public void newPatientNotes(String notes, String patientName, Date date) {
    String report = String.format(
        "Datetime Submitted: %s \n", date);
    report += String.format("Reported By ID: %s\n", this.id);
    report += String.format("Patient Name: %s\n", patientName);
    report += String.format("Notes: %s \n", notes);
    this.patientNotes.add(report);
  }

  @Override
  public boolean assignPin(int pin) {
    // int has no length, convert to a string and calculate the length

    if (String.valueOf(pin).length() == 4) {
      return true;
    }
    return false;
  }

  @Override
  public boolean accessAuthorized(Integer confirmedAuthID) {
    if (confirmedAuthID.equals(this.id)) {
      return true;
    }
    return false;
  }

  // TO DO: Setters & Getters
  public ArrayList<String> getPatientNotes() {
    return this.patientNotes;
  }

  public void setPatientNotes(ArrayList<String> patientNotes) {
    this.patientNotes = patientNotes;
  }


}
