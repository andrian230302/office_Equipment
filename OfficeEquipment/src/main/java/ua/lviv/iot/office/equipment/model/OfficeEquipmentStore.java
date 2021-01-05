package ua.lviv.iot.office.equipment.model;

import javax.persistence.*;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity
public class OfficeEquipmentStore {
  @Id
  @GeneratedValue(strategy = GenerationType.TABLE)
  private Integer id;

  private String name;

  private Integer yearOfOpening;


  @OneToMany(mappedBy = "officeEquipmentStore", fetch = FetchType.EAGER)
  @JsonIgnoreProperties("officeEquipmentStore")
  private Set<Mouse> mouses;


  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Integer getYearOfOpening() {
    return yearOfOpening;
  }

  public void setYearOfOpening(Integer yearOfOpening) {
    this.yearOfOpening = yearOfOpening;
  }

  public Set<Mouse> getMouses() {
    return mouses;
  }

  public void setMouses(Set<Mouse> mouses) {
    this.mouses = mouses;
  }

  public OfficeEquipmentStore() {
  }
}
