package builder;

/**
 * A class that represents a customer in a business.
 */
public class Customer {
  private String firstName;
  private String lastName;
  private String middleInitial;
  private String addressLineOne;
  private String addressLineTwo;
  private String city;
  private String state;
  private int zipcode;
  private String primaryPhone;
  private String cellPhone;
  private String userName; // online profile
  private double businessValue; // total amount earned from this customer
  private double percentageOnline; // percentage of amount earned by online order

  /**
   * Mandating that the client of the Customer class uses the builder requires
   * that we have a way to get the builder.
   * 
   * @return a builder to use to create a Customer.
   */
  public static CustomerBuilder getBuilder() {
    return new CustomerBuilder();
  }

  /*
   * A private constructor that can only be called from the CustomerBuider. This
   * works because the Builder is an inner class and has access to private
   * members.
   */
  private Customer(String firstName, String lastName, String middleInitial, String addressLineOne,
      String addressLineTwo, String city, String state, int zipcode, String primaryPhone,
      String cellPhone, String userName, double businessValue, double percentageOnline) {
    super();
    this.firstName = firstName;
    this.lastName = lastName;
    this.middleInitial = middleInitial;
    this.addressLineOne = addressLineOne;
    this.addressLineTwo = addressLineTwo;
    this.city = city;
    this.state = state;
    this.zipcode = zipcode;
    this.primaryPhone = primaryPhone;
    this.cellPhone = cellPhone;
    this.userName = userName;
    this.businessValue = businessValue;
    this.percentageOnline = percentageOnline;
  }

  // Lots of stuff missing from this class but none of this is required for this
  // example.

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder("[CUSTOMER hell: ");
    sb.append(firstName).append(" ");
    sb.append(middleInitial).append(". ");
    sb.append(lastName).append("\n");
    sb.append(addressLineOne).append("\n");
    sb.append(addressLineTwo).append("\n");
    sb.append(city).append(", ");
    sb.append(state).append(" ");
    sb.append(zipcode).append("\n");
    sb.append("Primary: ").append(primaryPhone).append(", ");
    sb.append("Cell: ").append(cellPhone).append("\n");
    sb.append("Username: ").append(userName).append("\n");
    sb.append("Value: ").append(businessValue).append(" (");
    sb.append(percentageOnline).append(")\n");
    return sb.toString();
  }

  /**
   * A builder class for building new Customers.
   */
  public static class CustomerBuilder {
    // maintains fields, one for each field in the actual complex class
    private String firstName;
    private String lastName;
    private String middleInitial;
    private String addressLineOne;
    private String addressLineTwo;
    private String city;
    private String state;
    private int zipcode;
    private String primaryPhone;
    private String cellPhone;
    private String userName; // online profile
    private double businessValue; // total amount earned from this customer
    private double percentageOnline; // percentage of amount earned by online order

    /*
     * Making this constructor private forces the client of this class to use the
     * static getBuilder method.
     */
    private CustomerBuilder() {
      // assign default values to all the fields as above
      firstName = "";
      lastName = "";
      middleInitial = "";
      addressLineOne = "";
      addressLineTwo = "";
      city = "Boston";
      state = "MA";
      zipcode = 02115;
      primaryPhone = "";
      cellPhone = "";
      userName = "";
      businessValue = 0.0;
      percentageOnline = 0.0;
    }

    /**
     * Use this for setting the Customer's first name.
     * 
     * @param firstName the first name.
     * @return this builder so that other methods can be called
     */
    public CustomerBuilder firstName(String firstName) {
      this.firstName = firstName;
      return this;
    }

    /**
     * Use this for setting the Customer's last name.
     * 
     * @param lastName the last name.
     * @return this builder so that other methods can be called
     */
    public CustomerBuilder lastName(String lastName) {
      this.lastName = lastName;
      return this;
    }

    // ...

    /**
     * Use this for setting the Customer's middle initial.
     * 
     * @param middleInitial the middle initial
     * @return this builder so that other methods can be called
     */
    public CustomerBuilder middleInitial(String middleInitial) {
      this.middleInitial = middleInitial;
      return this;
    }

    /**
     * Use this for setting the Customer's first line of the address.
     * 
     * @param addressLineOne the first line of the address
     * @return this builder so that other methods can be called
     */
    public CustomerBuilder addressLineOne(String addressLineOne) {
      this.addressLineOne = addressLineOne;
      return this;
    }

    /**
     * Use this for setting the Customer's second line of the address.
     * 
     * @param addressLineTwo the second line of the address
     * @return this builder so that other methods can be called
     */
    public CustomerBuilder addressLineTwo(String addressLineTwo) {
      this.addressLineTwo = addressLineTwo;
      return this;
    }

    /**
     * Use this for setting the Customer's city.
     * 
     * @param city the city
     * @return this builder so that other methods can be called
     */
    public CustomerBuilder city(String city) {
      this.city = city;
      return this;
    }

    /**
     * Use this for setting the Customer's state.
     * 
     * @param state the state
     * @return this builder so that other methods can be called
     */
    public CustomerBuilder state(String state) {
      this.state = state;
      return this;
    }

    /**
     * Use this for setting the Customer's zipcode.
     * 
     * @param zipcode the zipcode
     * @return this builder so that other methods can be called
     */
    public CustomerBuilder zipcode(int zipcode) {
      this.zipcode = zipcode;
      return this;
    }

    /**
     * Use this for setting the Customer's primary phone number.
     * 
     * @param primaryPhone the primary phone number
     * @return this builder so that other methods can be called
     */
    public CustomerBuilder primaryPhone(String primaryPhone) {
      this.primaryPhone = primaryPhone;
      return this;
    }

    /**
     * Use this for setting the Customer's cell phone number.
     * 
     * @param cellPhone the cell phone number
     * @return this builder so that other methods can be called
     */
    public CustomerBuilder cellPhone(String cellPhone) {
      this.cellPhone = cellPhone;
      return this;
    }

    /**
     * Use this for setting the Customer's user name.
     * 
     * @param userName the user name
     * @return this builder so that other methods can be called
     */
    public CustomerBuilder userName(String userName) {
      this.userName = userName;
      return this;
    }

    /**
     * Use this for setting the Customer's business value as a dollar amount.
     * 
     * @param businessValue the business value
     * @return this builder so that other methods can be called
     */
    public CustomerBuilder businessValue(double businessValue) {
      this.businessValue = businessValue;
      return this;
    }

    /**
     * Use this for setting the Customer's percentage of the business value that is
     * done online.
     * 
     * @param percentageOnline the percentage online
     * @return this builder so that other methods can be called
     */
    public CustomerBuilder percentageOnline(double percentageOnline) {
      this.percentageOnline = percentageOnline;
      return this;
    }

    /**
     * Build method called once all of the necessary data has been provided.
     * 
     * @return the customer
     */
    public Customer build() {
      // use the currently set values to create the Customer object
      return new Customer(firstName, lastName, middleInitial, addressLineOne, addressLineTwo, city,
          state, zipcode, primaryPhone, cellPhone, userName, businessValue, percentageOnline);
    }
  }
}