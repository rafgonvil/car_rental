package com.rent.car.model.dto;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * CarDTO
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2023-03-02T18:34:06.332+01:00")

public class CarDTO   {
  @JsonProperty("carId")
  private String carId = null;

  @JsonProperty("carType")
  private String carType = null;

  @JsonProperty("price")
  private Long price = null;

  public CarDTO carId(String carId) {
    this.carId = carId;
    return this;
  }

  /**
   * Get carId
   * @return carId
  **/
  @ApiModelProperty(value = "")


  public String getCarId() {
    return carId;
  }

  public void setCarId(String carId) {
    this.carId = carId;
  }

  public CarDTO carType(String carType) {
    this.carType = carType;
    return this;
  }

  /**
   * Get carType
   * @return carType
  **/
  @ApiModelProperty(value = "")


  public String getCarType() {
    return carType;
  }

  public void setCarType(String carType) {
    this.carType = carType;
  }

  public CarDTO price(Long price) {
    this.price = price;
    return this;
  }

  /**
   * Get price
   * @return price
  **/
  @ApiModelProperty(value = "")


  public Long getPrice() {
    return price;
  }

  public void setPrice(Long price) {
    this.price = price;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CarDTO carDTO = (CarDTO) o;
    return Objects.equals(this.carId, carDTO.carId) &&
        Objects.equals(this.carType, carDTO.carType) &&
        Objects.equals(this.price, carDTO.price);
  }

  @Override
  public int hashCode() {
    return Objects.hash(carId, carType, price);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CarDTO {\n");
    
    sb.append("    carId: ").append(toIndentedString(carId)).append("\n");
    sb.append("    carType: ").append(toIndentedString(carType)).append("\n");
    sb.append("    price: ").append(toIndentedString(price)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

