/**
 * The below class represents Monkey Food which is of enum type.
 */
public enum Food {
  EGGS("Eggs"), FRUITS("Fruits"), INSECTS("Insects"),
  LEAVES("Leaves"), NUTS("Nuts"), SEEDS("Seeds"),
  TREESAP("TreeSap");
  private String description;

  Food(String description) {
    this.description = description;
  }

  public String getValue() {
    return this.description;
  }
}
