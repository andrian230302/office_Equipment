package ua.lviv.iot.office.equipment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan({"ua.lviv.iot.office.equipment.dataaccess",
    "ua.lviv.iot.office.equipment.business",
    "ua.lviv.iot.office.equipment.controller"})
@EnableJpaRepositories({"ua.lviv.iot.office.equipment.dataaccess"})
public class RestApplication {

  public static void main(String[] args) {
    SpringApplication.run(RestApplication.class, args);
  }
}
