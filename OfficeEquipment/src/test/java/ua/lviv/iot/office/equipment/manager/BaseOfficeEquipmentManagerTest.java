package ua.lviv.iot.office.equipment.manager;

import ua.lviv.iot.office.equipment.model.*;

import java.util.LinkedList;
import java.util.List;

public abstract class BaseOfficeEquipmentManagerTest {
  protected List<AbstractOfficeEquipment> mouse;
  protected List<AbstractOfficeEquipment> computerScreen;
  protected List<AbstractOfficeEquipment> printer;

  public void createMouses() {
    mouse = new LinkedList<AbstractOfficeEquipment>();
    mouse.add(new Mouse(2014, "Andrew", 213.3d,
        "Black", 0.85d, CableForPower.USB, 3));

    mouse.add(new Mouse(2017, "Denis", 300.5d,
        "Black", 0.65d, CableForPower.USB, 5));
  }

  public void createComputerScreens() {
    computerScreen = new LinkedList<AbstractOfficeEquipment>();
    computerScreen.add(new ComputerScreen(2013, "Vlad", 2300.5d,
        "Black", 3.4d, CableForPower.USB, 15));
    computerScreen.add(new ComputerScreen(2018, "Ivan", 3500.5d,
        "Black", 2.3d, CableForPower.USB, 25));
  }

  public void createPrinters() {
    printer = new LinkedList<AbstractOfficeEquipment>();
    printer.add(new Printer(2016, "Adam", 1500.4d,
        "White", 5.4d, CableForPower.HDMI, TypeOfPrinter.COLORLESS));
    printer.add(new Printer(2020, "Adela", 2750.7d,
        "Black", 7.3d, CableForPower.USB, TypeOfPrinter.LASER));
    printer.add(new Printer(2019, "Alan", 3000.6d,
        "Blue", 6.3d, CableForPower.USB, TypeOfPrinter.LED));
  }

  public void createAllEquipments() {
    createMouses();
    createComputerScreens();
    createPrinters();
  }
}
