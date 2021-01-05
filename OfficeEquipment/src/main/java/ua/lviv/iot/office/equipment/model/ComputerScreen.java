package ua.lviv.iot.office.equipment.model;

public class ComputerScreen extends AbstractOfficeEquipment {
  private int numberOfInches;

  @Override
  public String getHeaders() {
    return super.getHeaders() + "," + " numberOfInches";
  }

  @Override
  public String toCSV() {
    return super.toCSV() + "," + numberOfInches;
  }

  public int getNumberOfInches() {
    return numberOfInches;
  }

  public void setNumberOfInches(int numberOfInches) {
    this.numberOfInches = numberOfInches;
  }

  public ComputerScreen(int productionYear, String producerName, double priceInUaH, String color,
                        double weightInKilograms, CableForPower cableForPower, int numberOfInches) {
    super(productionYear, producerName, priceInUaH, color, weightInKilograms, cableForPower);
    this.numberOfInches = numberOfInches;
  }
}
