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
 * CustomerDTO
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2023-03-02T17:46:34.470+01:00")

public class CustomerDTO   {
  @JsonProperty("customerId")
  private Long customerId = null;

  @JsonProperty("loyalty_point")
  private String loyaltyPoint = null;

  public CustomerDTO customerId(Long customerId) {
    this.customerId = customerId;
    return this;
  }

  /**
   * Get customerId
   * @return customerId
  **/
  @ApiModelProperty(value = "")


  public Long getCustomerId() {
    return customerId;
  }

  public void setCustomerId(Long customerId) {
    this.customerId = customerId;
  }

  public CustomerDTO loyaltyPoint(String loyaltyPoint) {
    this.loyaltyPoint = loyaltyPoint;
    return this;
  }

  /**
   * Get loyaltyPoint
   * @return loyaltyPoint
  **/
  @ApiModelProperty(value = "")


  public String getLoyaltyPoint() {
    return loyaltyPoint;
  }

  public void setLoyaltyPoint(String loyaltyPoint) {
    this.loyaltyPoint = loyaltyPoint;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CustomerDTO customerDTO = (CustomerDTO) o;
    return Objects.equals(this.customerId, customerDTO.customerId) &&
        Objects.equals(this.loyaltyPoint, customerDTO.loyaltyPoint);
  }

  @Override
  public int hashCode() {
    return Objects.hash(customerId, loyaltyPoint);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CustomerDTO {\n");
    
    sb.append("    customerId: ").append(toIndentedString(customerId)).append("\n");
    sb.append("    loyaltyPoint: ").append(toIndentedString(loyaltyPoint)).append("\n");
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

