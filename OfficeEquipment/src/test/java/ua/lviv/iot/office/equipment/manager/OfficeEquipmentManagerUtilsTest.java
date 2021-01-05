package ua.lviv.iot.office.equipment.manager;

import org.junit.jupiter.api.Test;
import ua.lviv.iot.office.equipment.model.SortType;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OfficeEquipmentManagerUtilsTest extends BaseOfficeEquipmentManagerTest {

  @Test
  public void testSortByProductionYearByAscending() {
    createAllEquipments();
    OfficeEquipmentManagerUtils.sortByProductionYearByAscending(printer, SortType.ASCENDING);
    assertEquals(2016, printer.get(0).getProductionYear());
  }

  @Test
  public void testSortByProductionYearDescending() {
    createAllEquipments();
    OfficeEquipmentManagerUtils.sortByProductionYearByDescending(mouse, SortType.DESCENDING);
    assertEquals(2017, mouse.get(0).getProductionYear());
  }

  @Test
  public void testSortByWeightInKilogramsAscending() {
    createAllEquipments();
    OfficeEquipmentManagerUtils.sortByWeightInKilogramsByAscending(computerScreen, SortType.ASCENDING);
    assertEquals(2.3d, computerScreen.get(0).getWeightInKilograms());
  }

  @Test
  public void testSortByWeightInKilogramsDescending() {
    createAllEquipments();
    OfficeEquipmentManagerUtils.sortByWeightInKilogramsByDescending(computerScreen, SortType.DESCENDING);
    assertEquals(3.4d, computerScreen.get(0).getWeightInKilograms());
  }

  @Test
  public void testSortByPrizeAscending() {
    createAllEquipments();
    OfficeEquipmentManagerUtils.sortByPrizeByAscending(printer, SortType.ASCENDING);
    assertEquals(1500.4d, printer.get(0).getPriceInUaH());

  }

  @Test
  public void testSortByPrizeDescending() {
    createAllEquipments();
    OfficeEquipmentManagerUtils.sortByPrizeByDescending(printer, SortType.DESCENDING);
    assertEquals(3000.6d, printer.get(0).getPriceInUaH());
  }


}
