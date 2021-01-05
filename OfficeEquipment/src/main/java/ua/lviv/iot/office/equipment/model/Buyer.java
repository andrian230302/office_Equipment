package ua.lviv.iot.office.equipment.model;



import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Set;

import javax.persistence.*;


@Entity
public class Buyer {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Integer id;

  private String name;

  @ManyToMany(fetch = FetchType.LAZY)
  @JoinTable(name = "Mouse_Buyers", joinColumns = {
      @JoinColumn(name = "buyer_id", nullable = false)}, inverseJoinColumns = {
      @JoinColumn(name = "mouse_id", nullable = false)})
  @JsonIgnoreProperties("buyers")
  private Set<Mouse> mouses;

  public Buyer() {

  }

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

  public Set<Mouse> getMouses() {
    return mouses;
  }

  public void setDresses(Set<Mouse> mouses) {
    this.mouses = mouses;
  }
}
