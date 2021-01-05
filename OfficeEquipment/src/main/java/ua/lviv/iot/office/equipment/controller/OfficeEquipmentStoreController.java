package ua.lviv.iot.office.equipment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.lviv.iot.office.equipment.business.OfficeEquipmentStoreService;
import ua.lviv.iot.office.equipment.model.OfficeEquipmentStore;

@RequestMapping("/stores")
@RestController
public class OfficeEquipmentStoreController {

  @Autowired
  private OfficeEquipmentStoreService officeEquipmentStoreService;

  @GetMapping
  public List<OfficeEquipmentStore> getAllStore() {
    return officeEquipmentStoreService.findAll();
  }

  @GetMapping(path = {"/{id}"})
  public ResponseEntity<OfficeEquipmentStore>
  getOfficeEquipmentStore(final @PathVariable("id") Integer officeEquipmentStoreId) {
    OfficeEquipmentStore officeEquipmentStore;
    ResponseEntity<OfficeEquipmentStore> status =
        (officeEquipmentStore = officeEquipmentStoreService.getOfficeEquipmentStore(
            officeEquipmentStoreId)) == null
            ? new ResponseEntity<>(HttpStatus.NOT_FOUND)
            : new ResponseEntity<>(officeEquipmentStore, HttpStatus.OK);
    return status;

  }

  @PostMapping
  public OfficeEquipmentStore createOfficeEquipmentStore(
      final @RequestBody OfficeEquipmentStore officeEquipmentStore) {
    return officeEquipmentStoreService.createOfficeEquipmentStore(officeEquipmentStore);
  }

  @DeleteMapping(path = {"/{id}"})
  public ResponseEntity<OfficeEquipmentStore> deleteStore(@PathVariable("id") Integer storeId) {
    HttpStatus status = officeEquipmentStoreService.deleteOfficeEquipmentStore(
        storeId) ? HttpStatus.OK : HttpStatus.NOT_FOUND;
    return ResponseEntity.status(status).build();
  }

  @PutMapping(path = {"/{id}"})
  public ResponseEntity<OfficeEquipmentStore> updateStore(final @PathVariable("id") Integer storeId,
                                                          final @RequestBody OfficeEquipmentStore
                                                              officeEquipmentStore) {
    officeEquipmentStore.setId(storeId);
    OfficeEquipmentStore oldStore =
        officeEquipmentStoreService.updateOfficeEquipmentStore(storeId, officeEquipmentStore);
    ResponseEntity<OfficeEquipmentStore> status = oldStore == null
        ? new ResponseEntity<OfficeEquipmentStore>(HttpStatus.NOT_FOUND)
        : new ResponseEntity<OfficeEquipmentStore>(oldStore, HttpStatus.OK);
    return status;
  }
}
