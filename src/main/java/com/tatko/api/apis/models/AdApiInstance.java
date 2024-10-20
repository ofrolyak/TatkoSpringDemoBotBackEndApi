package com.tatko.api.apis.models;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.v3.oas.annotations.media.Schema;
import java.time.LocalDateTime;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * AdApiInstance
 */
@Schema(description = "AdApiInstance")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2024-10-20T17:36:38.774954200+03:00[Europe/Kiev]")


public class AdApiInstance   {
  @JsonProperty("id")
  private Long id = null;

  @JsonProperty("ad")
  private String ad = null;

  @JsonProperty("deliveredTime")
  private LocalDateTime deliveredTime = null;

  @JsonProperty("creatingTime")
  private LocalDateTime creatingTime = null;

  public AdApiInstance id(Long id) {
    this.id = id;
    return this;
  }

  /**
   * Get id
   * @return id
   **/
  @Schema(description = "")
  
    public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public AdApiInstance ad(String ad) {
    this.ad = ad;
    return this;
  }

  /**
   * Get ad
   * @return ad
   **/
  @Schema(description = "")
  
    public String getAd() {
    return ad;
  }

  public void setAd(String ad) {
    this.ad = ad;
  }

  public AdApiInstance deliveredTime(LocalDateTime deliveredTime) {
    this.deliveredTime = deliveredTime;
    return this;
  }

  /**
   * Get deliveredTime
   * @return deliveredTime
   **/
  @Schema(description = "")
  
    @Valid
    public LocalDateTime getDeliveredTime() {
    return deliveredTime;
  }

  public void setDeliveredTime(LocalDateTime deliveredTime) {
    this.deliveredTime = deliveredTime;
  }

  public AdApiInstance creatingTime(LocalDateTime creatingTime) {
    this.creatingTime = creatingTime;
    return this;
  }

  /**
   * Get creatingTime
   * @return creatingTime
   **/
  @Schema(description = "")
  
    @Valid
    public LocalDateTime getCreatingTime() {
    return creatingTime;
  }

  public void setCreatingTime(LocalDateTime creatingTime) {
    this.creatingTime = creatingTime;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AdApiInstance adApiInstance = (AdApiInstance) o;
    return Objects.equals(this.id, adApiInstance.id) &&
        Objects.equals(this.ad, adApiInstance.ad) &&
        Objects.equals(this.deliveredTime, adApiInstance.deliveredTime) &&
        Objects.equals(this.creatingTime, adApiInstance.creatingTime);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, ad, deliveredTime, creatingTime);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AdApiInstance {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    ad: ").append(toIndentedString(ad)).append("\n");
    sb.append("    deliveredTime: ").append(toIndentedString(deliveredTime)).append("\n");
    sb.append("    creatingTime: ").append(toIndentedString(creatingTime)).append("\n");
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
