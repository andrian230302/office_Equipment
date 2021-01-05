package ua.lviv.iot.office.equipment.manager;

import java.io.Serializable;
import java.util.Comparator;
import java.util.List;
import ua.lviv.iot.office.equipment.model.AbstractOfficeEquipment;
import ua.lviv.iot.office.equipment.model.SortType;

public class OfficeEquipmentManagerUtils {

  public static final PrinterSortByProductionYear EQUIPMENT_BY_PRODUCTION_YEAR_SORTED
      = new PrinterSortByProductionYear();

  public static void sortByProductionYearByAscending(List<AbstractOfficeEquipment> equipments,
                                                     SortType sortType) {
    equipments.sort(sortType == SortType.ASCENDING ? EQUIPMENT_BY_PRODUCTION_YEAR_SORTED :
        EQUIPMENT_BY_PRODUCTION_YEAR_SORTED.reversed());
  }

  public static void sortByProductionYearByDescending(List<AbstractOfficeEquipment> equipments,
                                                      SortType sortType) {
    equipments.sort(sortType == SortType.ASCENDING ? EQUIPMENT_BY_PRODUCTION_YEAR_SORTED :
        EQUIPMENT_BY_PRODUCTION_YEAR_SORTED.reversed());
  }

  public static void sortByWeightInKilogramsByAscending(List<AbstractOfficeEquipment> equipments,
                                                        SortType sortType) {
    Comparator<AbstractOfficeEquipment> comparator
        = (firstAbstractOfficeEquipment, secondAbstractOfficeEquipment) ->
        (int) (firstAbstractOfficeEquipment
            .getWeightInKilograms() - secondAbstractOfficeEquipment.getWeightInKilograms());
    equipments.sort(sortType == SortType.ASCENDING ? comparator : comparator.reversed());

  }

  public static void sortByWeightInKilogramsByDescending(List<AbstractOfficeEquipment> equipments,
                                                         SortType sortType) {
    Comparator<AbstractOfficeEquipment> comparator =
        Comparator.comparing(AbstractOfficeEquipment::getWeightInKilograms);

    equipments.sort(sortType == SortType.ASCENDING ? comparator : comparator.reversed());

  }

  public static void sortByPrizeByAscending(List<AbstractOfficeEquipment> equipments,
                                            SortType sortType) {
    Comparator<AbstractOfficeEquipment> comparator = new Comparator<AbstractOfficeEquipment>() {
      @Override
      public int compare(AbstractOfficeEquipment firstAbstractOfficeEquipment,
                         AbstractOfficeEquipment secondAbstractOfficeEquipment) {
        return (int) (firstAbstractOfficeEquipment
            .getPriceInUaH() - secondAbstractOfficeEquipment.getPriceInUaH());

      }
    };

    equipments.sort(sortType == SortType.ASCENDING ? comparator : comparator.reversed());
  }

  public static void sortByPrizeByDescending(List<AbstractOfficeEquipment> equipments,
                                             SortType sortType) {
    Comparator<AbstractOfficeEquipment> comparator = new Comparator<AbstractOfficeEquipment>() {
      @Override
      public int compare(AbstractOfficeEquipment firstAbstractOfficeEquipment,
                         AbstractOfficeEquipment secondAbstractOfficeEquipment) {
        return (int) (firstAbstractOfficeEquipment
            .getPriceInUaH() - secondAbstractOfficeEquipment.getPriceInUaH());

      }
    };

    equipments.sort(sortType == SortType.ASCENDING ? comparator : comparator.reversed());
  }

  static class PrinterSortByProductionYear implements Comparator<AbstractOfficeEquipment>,
      Serializable {

    @Override
    public int compare(AbstractOfficeEquipment firstAbstractOfficeEquipment,
                       AbstractOfficeEquipment secondAbstractOfficeEquipment) {
      return firstAbstractOfficeEquipment
          .getProductionYear() - secondAbstractOfficeEquipment.getProductionYear();
    }
  }
}
