package com.rent.car.model.dto;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.rent.car.model.dto.CarDTO;
import com.rent.car.model.dto.CustomerDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * ReservationDTO
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2023-03-02T18:47:26.959+01:00")

public class ReservationDTO   {
  @JsonProperty("car")
  private CarDTO car = null;

  @JsonProperty("customer")
  private CustomerDTO customer = null;

  @JsonProperty("startDate")
  private String startDate = null;

  @JsonProperty("endDate")
  private String endDate = null;

  @JsonProperty("reservationPrice")
  private String reservationPrice = null;

  @JsonProperty("penaltyPrice")
  private String penaltyPrice = null;

  @JsonProperty("finalPrice")
  private String finalPrice = null;

  public ReservationDTO car(CarDTO car) {
    this.car = car;
    return this;
  }

  /**
   * Get car
   * @return car
  **/
  @ApiModelProperty(value = "")

  @Valid

  public CarDTO getCar() {
    return car;
  }

  public void setCar(CarDTO car) {
    this.car = car;
  }

  public ReservationDTO customer(CustomerDTO customer) {
    this.customer = customer;
    return this;
  }

  /**
   * Get customer
   * @return customer
  **/
  @ApiModelProperty(value = "")

  @Valid

  public CustomerDTO getCustomer() {
    return customer;
  }

  public void setCustomer(CustomerDTO customer) {
    this.customer = customer;
  }

  public ReservationDTO startDate(String startDate) {
    this.startDate = startDate;
    return this;
  }

  /**
   * Get startDate
   * @return startDate
  **/
  @ApiModelProperty(value = "")


  public String getStartDate() {
    return startDate;
  }

  public void setStartDate(String startDate) {
    this.startDate = startDate;
  }

  public ReservationDTO endDate(String endDate) {
    this.endDate = endDate;
    return this;
  }

  /**
   * Get endDate
   * @return endDate
  **/
  @ApiModelProperty(value = "")


  public String getEndDate() {
    return endDate;
  }

  public void setEndDate(String endDate) {
    this.endDate = endDate;
  }

  public ReservationDTO reservationPrice(String reservationPrice) {
    this.reservationPrice = reservationPrice;
    return this;
  }

  /**
   * Get reservationPrice
   * @return reservationPrice
  **/
  @ApiModelProperty(value = "")


  public String getReservationPrice() {
    return reservationPrice;
  }

  public void setReservationPrice(String reservationPrice) {
    this.reservationPrice = reservationPrice;
  }

  public ReservationDTO penaltyPrice(String penaltyPrice) {
    this.penaltyPrice = penaltyPrice;
    return this;
  }

  /**
   * Get penaltyPrice
   * @return penaltyPrice
  **/
  @ApiModelProperty(value = "")


  public String getPenaltyPrice() {
    return penaltyPrice;
  }

  public void setPenaltyPrice(String penaltyPrice) {
    this.penaltyPrice = penaltyPrice;
  }

  public ReservationDTO finalPrice(String finalPrice) {
    this.finalPrice = finalPrice;
    return this;
  }

  /**
   * Get finalPrice
   * @return finalPrice
  **/
  @ApiModelProperty(value = "")


  public String getFinalPrice() {
    return finalPrice;
  }

  public void setFinalPrice(String finalPrice) {
    this.finalPrice = finalPrice;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ReservationDTO reservationDTO = (ReservationDTO) o;
    return Objects.equals(this.car, reservationDTO.car) &&
        Objects.equals(this.customer, reservationDTO.customer) &&
        Objects.equals(this.startDate, reservationDTO.startDate) &&
        Objects.equals(this.endDate, reservationDTO.endDate) &&
        Objects.equals(this.reservationPrice, reservationDTO.reservationPrice) &&
        Objects.equals(this.penaltyPrice, reservationDTO.penaltyPrice) &&
        Objects.equals(this.finalPrice, reservationDTO.finalPrice);
  }

  @Override
  public int hashCode() {
    return Objects.hash(car, customer, startDate, endDate, reservationPrice, penaltyPrice, finalPrice);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ReservationDTO {\n");
    
    sb.append("    car: ").append(toIndentedString(car)).append("\n");
    sb.append("    customer: ").append(toIndentedString(customer)).append("\n");
    sb.append("    startDate: ").append(toIndentedString(startDate)).append("\n");
    sb.append("    endDate: ").append(toIndentedString(endDate)).append("\n");
    sb.append("    reservationPrice: ").append(toIndentedString(reservationPrice)).append("\n");
    sb.append("    penaltyPrice: ").append(toIndentedString(penaltyPrice)).append("\n");
    sb.append("    finalPrice: ").append(toIndentedString(finalPrice)).append("\n");
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

