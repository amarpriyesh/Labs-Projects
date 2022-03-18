package transmission;

/**
 * AutomaticTransmission represents rotation of an engine by controlling the gear.
 * In this class we are taking 5 speed constants to show the automatic working of gear system.
 */
public class AutomaticTransmission implements Transmission {

  private final int speed1;
  private final int speed2;
  private final int speed3;
  private final int speed4;
  private final int speed5;
  private int speedInitial;

  /**
   * the below constructor uses the below parameters to create an automatic transmission object.
   *
   * @param speed1 this speed constant can't be zero and it should be less than speed2.
   * @param speed2 this speed constant can't be zero and it should be less than speed3.
   * @param speed3 this speed constant can't be zero and it should be less than speed4.
   * @param speed4 this speed constant can't be zero and it should be less than speed5.
   * @param speed5 this speed constant can't be zero.
   */
  public AutomaticTransmission(int speed1, int speed2, int speed3, int speed4, int speed5) {

    if ((speed1 >= speed2 || speed2 >= speed3 || speed3 >= speed4 || speed4 >= speed5)) {
      throw new IllegalArgumentException("Preceding speed cant be greater.");
    }
    if ((speed1 < 0 || speed2 < 0 || speed3 < 0 || speed4 < 0 || speed5 < 0)) {
      throw new IllegalArgumentException("Speed can't be negative");
    }
    if ((speed1 == 0)) {
      throw new IllegalArgumentException("Speed1 can't be Zero");
    }

    this.speed1 = speed1;
    this.speed2 = speed2;
    this.speed3 = speed3;
    this.speed4 = speed4;
    this.speed5 = speed5;
    this.speedInitial = 0;


  }

  /**
   * Increases the speed by 1 MPH updating the gear appropriately.
   */
  @Override
  public void increaseSpeed() {

    this.speedInitial = this.speedInitial + 1;
  }

  /**
   * Decreases the speed by 1 MPH updating the gear appropriately.
   *
   * @throws IllegalStateException if called would cause the speed to go below 0
   */
  @Override
  public void decreaseSpeed() throws IllegalStateException {

    this.speedInitial = this.speedInitial - 1;
    if (speedInitial < 0) {
      throw new IllegalStateException("Speed of the car can't be negative");

    }

  }

  /**
   * Gets the speed of this Transmission.
   *
   * @return the speed
   */
  @Override
  public int getSpeed() {
    return this.speedInitial;
  }

  /**
   * Gets the gear of this Transmission.
   *
   * @return the gear
   */
  @Override
  public int getGear() {

    return setGear();
  }

  /**
   * Helper method for getGear method.
   *
   * @return the gear
   */
  private int setGear() {
    if (this.speedInitial == 0) {
      return 0;
    } else if (this.speedInitial > 0 && this.speedInitial < this.speed1) {
      return 1;
    } else if (this.speedInitial >= this.speed1 && this.speedInitial < this.speed2) {
      return 2;
    } else if (this.speedInitial >= this.speed2 && this.speedInitial < this.speed3) {
      return 3;
    } else if (this.speedInitial >= this.speed3 && this.speedInitial < this.speed4) {
      return 4;
    } else if (this.speedInitial >= this.speed4 && this.speedInitial < this.speed5) {
      return 5;
    } else if (this.speedInitial >= this.speed5) {
      return 6;
    }
    return 0;
  }

  @Override
  public String toString() {
    return String.format("Transmission (speed = %d, gear = %d)",
            this.speedInitial,
            this.getGear());
  }

  @Override
  public boolean equals(Object o) {

    if (this == o) {
      return true;
    }

    if (!(o instanceof Transmission)) {
      return false;
    }

    Transmission that = (Transmission) o;
    return this.toString().equals(that.toString());


  }

  @Override
  public int hashCode() {
    return this.toString().hashCode();
  }
}

