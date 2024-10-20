package com.tatko.api.apis.models;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * AdCreateRequest
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2024-10-20T17:36:38.774954200+03:00[Europe/Kiev]")


public class AdCreateRequest   {
  @JsonProperty("ad")
  private String ad = null;

  public AdCreateRequest ad(String ad) {
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


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AdCreateRequest adCreateRequest = (AdCreateRequest) o;
    return Objects.equals(this.ad, adCreateRequest.ad);
  }

  @Override
  public int hashCode() {
    return Objects.hash(ad);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AdCreateRequest {\n");
    
    sb.append("    ad: ").append(toIndentedString(ad)).append("\n");
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
