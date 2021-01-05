package ua.lviv.iot.office.equipment.writer;

import java.io.IOException;
import java.io.Writer;
import java.util.List;
import ua.lviv.iot.office.equipment.model.AbstractOfficeEquipment;



public class OfficeEquipmentWriter {

  private Writer csvWriter;

  public void setCsvWriter(Writer csvWriter) {
    this.csvWriter = csvWriter;
  }

  public void writeToFile(List<AbstractOfficeEquipment> officeEquipments) throws IOException {
    for (AbstractOfficeEquipment officeEquipment : officeEquipments) {
      csvWriter.write(officeEquipment.getHeaders());
      csvWriter.write("\n");
      csvWriter.write(officeEquipment.toCSV());
      csvWriter.write("\n");
      csvWriter.flush();
    }
  }
}
