package ua.lviv.iot.office.equipment.manager;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ua.lviv.iot.office.equipment.model.AbstractOfficeEquipment;

import java.util.List;

public class OfficeEquipmentManagerTest extends BaseOfficeEquipmentManagerTest {

  private OfficeEquipmentManager officeEquipmentManager;

  @BeforeEach
  public void setUp() {
    officeEquipmentManager = new OfficeEquipmentManager();

    createAllEquipments();

    officeEquipmentManager.addEquipments(computerScreen);
    officeEquipmentManager.addEquipments(mouse);
    officeEquipmentManager.addEquipments(printer);
  }

  @Test
  public void testFindWithPriceInRange() {
    List<AbstractOfficeEquipment> equipment = officeEquipmentManager.findWithPriceInRange(1500.7, 2600.4);
    assertEquals(7, equipment.size());

  }

}
