package ua.lviv.iot.office.equipment.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ua.lviv.iot.office.equipment.model.AbstractOfficeEquipment;
import ua.lviv.iot.office.equipment.writer.OfficeEquipmentWriter;

import java.io.File;
import java.io.FileWriter;
import java.io.StringWriter;
import java.io.Writer;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class OfficeEquipmentWriterTest extends BaseOfficeEquipmentManagerTest {


  @BeforeEach
  public void setUp() {
    createAllEquipments();
  }

  @Test
  void testOfficeEquipmentWriter() {
    try (Writer csvWriter = new FileWriter(new File("officeEquipment.csv"))) {
      OfficeEquipmentWriter writer = new OfficeEquipmentWriter();
      writer.setCsvWriter(csvWriter);
      writer.writeToFile(printer);
      writer.writeToFile(mouse);
      writer.writeToFile(computerScreen);
    } catch (Exception e) {
      fail("test failed");
    }
  }

  @Test
  public void testProperTextFormatting() {
    try (Writer csvWriter = new StringWriter()) {
      OfficeEquipmentWriter writer = new OfficeEquipmentWriter();
      writer.setCsvWriter(csvWriter);

      writer.writeToFile(printer);
      writer.writeToFile(mouse);
      writer.writeToFile(computerScreen);

      String expectedOutput = "";
      for (AbstractOfficeEquipment printer : printer) {
        expectedOutput += printer.getHeaders() + "\n" + printer.toCSV() + "\n";
      }
      for (AbstractOfficeEquipment mouse : mouse) {
        expectedOutput += mouse.getHeaders() + "\n" + mouse.toCSV() + "\n";
      }
      for (AbstractOfficeEquipment computerScreen : computerScreen) {
        expectedOutput += computerScreen.getHeaders() + "\n" + computerScreen.toCSV() + "\n";
      }
      assertEquals(expectedOutput, csvWriter.toString());
    } catch (Exception e) {
      fail("the test failed unexpected - try to write to the file ");
    }
  }
}
