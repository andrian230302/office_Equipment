package ua.lviv.iot.office.equipment.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.lviv.iot.office.equipment.dataaccess.OfficeEquipmentStoreRepository;
import ua.lviv.iot.office.equipment.model.OfficeEquipmentStore;


@Service
public class OfficeEquipmentStoreService {

  @Autowired
  private OfficeEquipmentStoreRepository officeEquipmentStoreRepository;

  public List<OfficeEquipmentStore> findAll() {
    return officeEquipmentStoreRepository.findAll();
  }

  public OfficeEquipmentStore getOfficeEquipmentStore(Integer id) {
    if (officeEquipmentStoreRepository.existsById(id)) {
      return officeEquipmentStoreRepository.findById(id).get();
    } else {
      return null;
    }
  }

  public OfficeEquipmentStore createOfficeEquipmentStore(
      OfficeEquipmentStore officeEquipmentStore) {
    return officeEquipmentStoreRepository.save(officeEquipmentStore);
  }

  public boolean deleteOfficeEquipmentStore(Integer id) {
    if (officeEquipmentStoreRepository.existsById(id)) {
      officeEquipmentStoreRepository.deleteById(id);
      return true;
    } else {
      return false;
    }
  }

  public OfficeEquipmentStore updateOfficeEquipmentStore(
      Integer id,
      OfficeEquipmentStore officeEquipmentStore) {
    if (officeEquipmentStoreRepository.existsById(id)) {
      OfficeEquipmentStore previousOfficeEquipmentStore =
          officeEquipmentStoreRepository.findById(id).get();
      officeEquipmentStoreRepository.save(officeEquipmentStore);
      return previousOfficeEquipmentStore;
    } else {
      return null;
    }
  }


}
