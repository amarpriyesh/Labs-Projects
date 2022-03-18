package builder;

/**
 * A driver class that shows how to use the builder in the Cusotomer class.
 */
public class BuilderDriver {

  /**
   * Main driver program to show how to use a CustomerBuilder.
   * @param args Not used.
   */
  public static void main(String[] args) {
    // Build a customer using only the information that you require.
    Customer customer = Customer.getBuilder()
        .firstName("Tom")
        .lastName("Cruise")
        .primaryPhone("1112223333")
        .build();

    customer.getBuilder().addressLineTwo("abc").build();
    System.out.println(customer);
  }
}
