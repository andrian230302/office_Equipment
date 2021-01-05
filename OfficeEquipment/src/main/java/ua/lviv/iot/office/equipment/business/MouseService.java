package ua.lviv.iot.office.equipment.business;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.lviv.iot.office.equipment.dataaccess.MouseRepository;
import ua.lviv.iot.office.equipment.model.Mouse;


@Service
public class MouseService {

  @Autowired
  private MouseRepository mouseRepository;

  public Mouse getMouse(Integer id) {
    if (mouseRepository.existsById(id)) {
      return mouseRepository.findById(id).get();
    } else {
      return null;
    }
  }

  public Mouse createMouse(Mouse mouse) {
    return mouseRepository.save(mouse);
  }

  public boolean deleteMouse(Integer id) {
    if (mouseRepository.existsById(id)) {
      mouseRepository.deleteById(id);
      return true;
    } else {
      return false;
    }
  }

  public Mouse updateMouse(Integer id, Mouse mouse) {
    if (mouseRepository.existsById(id)) {
      Mouse previousMouse = mouseRepository.findById(id).get();
      mouseRepository.save(mouse);
      return previousMouse;
    } else {
      return null;
    }
  }

  public List<Mouse> findAll() {
    return mouseRepository.findAll();
  }

  public List<Mouse> getAllByProducerName(String producerName) {
    return mouseRepository.findAllByProducerName(producerName);

  }

  public List<Mouse> searchByProducerName(String producerName) {
    return findAll().stream()
            .filter(mouse -> mouse.getProducerName().contains(producerName))
            .collect(Collectors.toList());
  }
}
