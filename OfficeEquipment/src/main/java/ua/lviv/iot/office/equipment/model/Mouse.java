package ua.lviv.iot.office.equipment.model;

import javax.persistence.*;
import java.util.Set;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity
public class Mouse extends AbstractOfficeEquipment {
  private int numberOfButton;

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Integer id;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "officeEquipmentStore_id")
  @JsonIgnoreProperties("mouses")
  private OfficeEquipmentStore officeEquipmentStore;

  @ManyToMany(fetch = FetchType.LAZY)
  @JoinTable(name = "Mouse_Buyers", joinColumns = {
      @JoinColumn(name = "mouse_id", nullable = false)}, inverseJoinColumns = {
      @JoinColumn(name = "buyer_id", nullable = true)})
  @JsonIgnoreProperties("mouses")
  private Set<Buyer> buyers;

  public Set<Buyer> getBuyers() {
    return buyers;
  }

  public void setBuyers(Set<Buyer> buyers) {
    this.buyers = buyers;
  }

  public OfficeEquipmentStore getOfficeEquipmentStore() {
    return officeEquipmentStore;
  }

  public void setOfficeEquipmentStore(OfficeEquipmentStore officeEquipmentStore) {
    this.officeEquipmentStore = officeEquipmentStore;
  }
  @Override
  public String getHeaders() {
    return super.getHeaders() + "," + "numberOfButton ";
  }

  @Override
  public String toCSV() {
    return super.toCSV() + "," + numberOfButton;
  }

  public int getNumberOfButton() {
    return numberOfButton;
  }

  public void setNumberOfButton(int numberOfButton) {
    this.numberOfButton = numberOfButton;
  }

  public Mouse(int productionYear, String producerName, double priceInUaH, String color,
               double weightInKilograms, CableForPower cableForPower, int numberOfButton) {
    super(productionYear, producerName, priceInUaH, color, weightInKilograms, cableForPower);
    this.numberOfButton = numberOfButton;
  }

  public Mouse() {

  }
}
