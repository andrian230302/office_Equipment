package ua.lviv.iot.office.equipment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.lviv.iot.office.equipment.business.BuyerService;
import ua.lviv.iot.office.equipment.model.Buyer;


@RequestMapping("/buyers")
@RestController
public class BuyerController {

  @Autowired
  private BuyerService buyerService;

  @GetMapping
  public List<Buyer> getAllBuyer() {
    return buyerService.findAll();
  }

  @GetMapping(path = {"/{id}"})
  public ResponseEntity<Buyer> getBuyer(final @PathVariable("id") Integer buyerId) {

    Buyer buyer;
    ResponseEntity<Buyer> status = (buyer = buyerService.getBoyer(buyerId)) == null
        ? new ResponseEntity<>(HttpStatus.NOT_FOUND)
        : new ResponseEntity<>(buyer, HttpStatus.OK);
    return status;

  }

  @PostMapping(produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
  public Buyer createBuyer(@RequestBody Buyer buyer) {
    buyerService.createBuyer(buyer);
    return buyer;
  }

  @DeleteMapping(path = {"/{id}"})
  public ResponseEntity<Buyer> deleteBuyer(@PathVariable("id") Integer buyerId) {
    HttpStatus status = buyerService.deleteBuyer(buyerId) ? HttpStatus.OK : HttpStatus.NOT_FOUND;

    return ResponseEntity.status(status).build();
  }

  @PutMapping(path = {"/{id}"})
  public ResponseEntity<Buyer> updateBuyer(final @PathVariable("id") Integer buyerId,
                                           final @RequestBody Buyer buyer) {
    buyer.setId(buyerId);
    Buyer oldBuyer = buyerService.updateBuyer(buyerId, buyer);
    ResponseEntity<Buyer> status = oldBuyer == null
        ? new ResponseEntity<Buyer>(HttpStatus.NOT_FOUND)
        : new ResponseEntity<Buyer>(oldBuyer, HttpStatus.OK);
    return status;
  }
}
