package com.rent.car.model.dto;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.rent.car.model.dto.CustomerDTO;
import com.rent.car.model.dto.ReservationCalcualtedDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * ReservationSurchargesDTO
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2023-03-02T18:34:06.332+01:00")

public class ReservationSurchargesDTO   {
  @JsonProperty("customer")
  private CustomerDTO customer = null;

  @JsonProperty("reservations")
  @Valid
  private List<ReservationCalcualtedDTO> reservations = null;

  public ReservationSurchargesDTO customer(CustomerDTO customer) {
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

  public ReservationSurchargesDTO reservations(List<ReservationCalcualtedDTO> reservations) {
    this.reservations = reservations;
    return this;
  }

  public ReservationSurchargesDTO addReservationsItem(ReservationCalcualtedDTO reservationsItem) {
    if (this.reservations == null) {
      this.reservations = new ArrayList<>();
    }
    this.reservations.add(reservationsItem);
    return this;
  }

  /**
   * Get reservations
   * @return reservations
  **/
  @ApiModelProperty(value = "")

  @Valid

  public List<ReservationCalcualtedDTO> getReservations() {
    return reservations;
  }

  public void setReservations(List<ReservationCalcualtedDTO> reservations) {
    this.reservations = reservations;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ReservationSurchargesDTO reservationSurchargesDTO = (ReservationSurchargesDTO) o;
    return Objects.equals(this.customer, reservationSurchargesDTO.customer) &&
        Objects.equals(this.reservations, reservationSurchargesDTO.reservations);
  }

  @Override
  public int hashCode() {
    return Objects.hash(customer, reservations);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ReservationSurchargesDTO {\n");
    
    sb.append("    customer: ").append(toIndentedString(customer)).append("\n");
    sb.append("    reservations: ").append(toIndentedString(reservations)).append("\n");
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

