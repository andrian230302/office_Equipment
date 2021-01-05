package ua.lviv.iot.office.equipment.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.lviv.iot.office.equipment.dataaccess.BuyerRepository;
import ua.lviv.iot.office.equipment.model.Buyer;


@Service
public class BuyerService {

  @Autowired
  private BuyerRepository buyerRepository;

  public Buyer createBuyer(Buyer buyer) {
    return buyerRepository.save(buyer);
  }

  public List<Buyer> findAll() {
    return buyerRepository.findAll();
  }

  public boolean deleteBuyer(Integer id) {
    if (buyerRepository.existsById(id)) {
      buyerRepository.deleteById(id);
      return true;
    } else {
      return false;
    }
  }

  public Buyer updateBuyer(Integer id, Buyer buyer) {
    if (buyerRepository.existsById(id)) {
      Buyer previousBuyer = buyerRepository.findById(id).get();
      buyerRepository.save(buyer);
      return previousBuyer;
    } else {
      return null;
    }
  }


  public Buyer getBoyer(Integer id) {
    if (buyerRepository.existsById(id)) {
      return buyerRepository.findById(id).get();
    } else {
      return null;
    }
  }
}
