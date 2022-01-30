package hw2;

import javax.swing.*;

/**
 *
 */
public class Recipient {
  private String firstName;
  private String lastName;
  private String emailAddress;

  /**
   * @param firstName
   * @param lastName
   * @param emailAddress
   * @throws IllegalArgumentException
   */
  public Recipient(String firstName, String lastName, String emailAddress) throws
          IllegalArgumentException{
    String[] input = {firstName,lastName,emailAddress};
    if (isNull(input)) throw new IllegalArgumentException();
    else{
      this.firstName = firstName;
      this.lastName = lastName;
      this.emailAddress = emailAddress;
    }
  }

  /**
   * @param input
   * @return
   */
  private boolean isNull(String[] input){
    for (int i=0;i<3;i++){
      if (input[i] == null || input[i] == "" ? true : false) return true;
    }
    return false;
  }


  /**
   * @return
   */
  @Override
  public String toString(){
    return String.format("%s %s Email:%s",firstName,lastName,emailAddress);
  }
}
