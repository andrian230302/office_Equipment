package ua.lviv.iot.office.equipment.model;

public class Printer extends AbstractOfficeEquipment {
  private TypeOfPrinter typeOfPrinter;

  @Override
  public String getHeaders() {
    return super.getHeaders() + "," + "typeOfPrinter";
  }

  @Override
  public String toCSV() {
    return super.toCSV() + "," + typeOfPrinter;
  }

  public TypeOfPrinter getTypeOfPrinter() {
    return typeOfPrinter;
  }

  public void setTypeOfPrinter(TypeOfPrinter typeOfPrinter) {
    this.typeOfPrinter = typeOfPrinter;
  }

  public Printer(int productionYear, String producerName, double priceInUaH, String color,
                 double weightInKilograms, CableForPower cableForPower,
                 TypeOfPrinter typeOfPrinter) {
    super(productionYear, producerName, priceInUaH, color, weightInKilograms, cableForPower);
    this.typeOfPrinter = typeOfPrinter;
  }
}
