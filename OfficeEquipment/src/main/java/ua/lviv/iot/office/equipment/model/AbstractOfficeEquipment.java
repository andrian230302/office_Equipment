package ua.lviv.iot.office.equipment.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class AbstractOfficeEquipment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private int productionYear;
    private String producerName;
    private double priceInUaH;
    private String color;
    private double weightInKilograms;
    private CableForPower cableForPower;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    public String getHeaders() {
        return "productionYear, producerName, priceInUaH, color, weightInKilograms, cableForPower";
    }

    public String toCSV() {
        return productionYear + "," + producerName + "," + priceInUaH + ","
                + color + "," + weightInKilograms + "," + cableForPower;
    }

    public double getWeightInKilograms() {
        return weightInKilograms;
    }

    public void setWeightInKilograms(double weightInKilograms) {
        this.weightInKilograms = weightInKilograms;
    }

    public CableForPower getCableForPower() {
        return cableForPower;
    }

    public void setCableForPower(CableForPower cableForPower) {
        this.cableForPower = cableForPower;
    }

    public String getProducerName() {
        return producerName;
    }

    public void setProducerName(String producerName) {
        this.producerName = producerName;
    }

    public double getPriceInUaH() {
        return priceInUaH;
    }

    public void setPriceInUaH(double priceInUaH) {
        this.priceInUaH = priceInUaH;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getProductionYear() {
        return productionYear;
    }

    public void setProductionYear(int productionYear) {
        this.productionYear = productionYear;
    }

    public AbstractOfficeEquipment(int productionYear, String producerName,
                                   double priceInUaH, String color,
                                   double weightInKilograms, CableForPower cableForPower) {
        this.productionYear = productionYear;
        this.producerName = producerName;
        this.priceInUaH = priceInUaH;
        this.color = color;
        this.weightInKilograms = weightInKilograms;
        this.cableForPower = cableForPower;
    }

    public AbstractOfficeEquipment() {

    }

}
