package ua.lviv.iot.office.equipment.manager;


import java.util.LinkedList;
import java.util.List;
import ua.lviv.iot.office.equipment.model.AbstractOfficeEquipment;


public class OfficeEquipmentManager {

  private List<AbstractOfficeEquipment> equipments = new LinkedList<>();


  public void addEquipments(List<AbstractOfficeEquipment> equipments) {

    this.equipments.addAll(equipments);
  }

  public void addEquipment(AbstractOfficeEquipment equipments) {

    this.equipments.add(equipments);
  }

  public List<AbstractOfficeEquipment> findWithPriceInRange(double minPrice, double maxPrice) {

    LinkedList<AbstractOfficeEquipment> result = new LinkedList<>();
    for (AbstractOfficeEquipment equipment : equipments) {
      if (equipment.getProductionYear() > minPrice && equipment.getProductionYear() < maxPrice) {
        result.add(equipment);
      }
    }
    return result;
  }
}
