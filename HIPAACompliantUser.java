public interface HIPAACompliantUser {
  abstract boolean assignPin(int pin);
  abstract boolean accessAuthorized(Integer confirmedAuthID);
}
// abstract means it has to be implemented