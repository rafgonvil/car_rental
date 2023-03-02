package com.rent.car.model.dto;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * CollectionCarsReservations
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2023-03-02T18:47:26.959+01:00")

public class CollectionCarsReservations   {
  @JsonProperty("cars")
  @Valid
  private List<String> cars = null;

  @JsonProperty("customerId")
  private Long customerId = null;

  @JsonProperty("endDate")
  private String endDate = null;

  public CollectionCarsReservations cars(List<String> cars) {
    this.cars = cars;
    return this;
  }

  public CollectionCarsReservations addCarsItem(String carsItem) {
    if (this.cars == null) {
      this.cars = new ArrayList<>();
    }
    this.cars.add(carsItem);
    return this;
  }

  /**
   * Get cars
   * @return cars
  **/
  @ApiModelProperty(example = "[\"BMW 7\",\"Kia Sorendo\"]", value = "")


  public List<String> getCars() {
    return cars;
  }

  public void setCars(List<String> cars) {
    this.cars = cars;
  }

  public CollectionCarsReservations customerId(Long customerId) {
    this.customerId = customerId;
    return this;
  }

  /**
   * Get customerId
   * @return customerId
  **/
  @ApiModelProperty(example = "1", value = "")


  public Long getCustomerId() {
    return customerId;
  }

  public void setCustomerId(Long customerId) {
    this.customerId = customerId;
  }

  public CollectionCarsReservations endDate(String endDate) {
    this.endDate = endDate;
    return this;
  }

  /**
   * Get endDate
   * @return endDate
  **/
  @ApiModelProperty(example = "23/03/2023", value = "")


  public String getEndDate() {
    return endDate;
  }

  public void setEndDate(String endDate) {
    this.endDate = endDate;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CollectionCarsReservations collectionCarsReservations = (CollectionCarsReservations) o;
    return Objects.equals(this.cars, collectionCarsReservations.cars) &&
        Objects.equals(this.customerId, collectionCarsReservations.customerId) &&
        Objects.equals(this.endDate, collectionCarsReservations.endDate);
  }

  @Override
  public int hashCode() {
    return Objects.hash(cars, customerId, endDate);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CollectionCarsReservations {\n");
    
    sb.append("    cars: ").append(toIndentedString(cars)).append("\n");
    sb.append("    customerId: ").append(toIndentedString(customerId)).append("\n");
    sb.append("    endDate: ").append(toIndentedString(endDate)).append("\n");
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

