package ua.lviv.iot.office.equipment.dataaccess;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.lviv.iot.office.equipment.model.Mouse;


@Repository
public interface MouseRepository extends JpaRepository<Mouse, Integer> {

  List<Mouse> findAllByProducerName(String producerName);

}
