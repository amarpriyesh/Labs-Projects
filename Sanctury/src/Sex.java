public enum Sex {
  F("Female"),M("Male");
  private String description;
  Sex(String description) {
    this.description=description;
  }

  public String getValue() {
    return this.description;
  }
}
