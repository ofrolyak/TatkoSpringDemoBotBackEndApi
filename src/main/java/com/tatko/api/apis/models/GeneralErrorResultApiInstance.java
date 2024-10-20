package com.tatko.api.apis.models;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.tatko.api.apis.models.MsgsApiInstance;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * GeneralErrorResultApiInstance
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2024-10-20T17:36:38.774954200+03:00[Europe/Kiev]")


public class GeneralErrorResultApiInstance   {
  @JsonProperty("msgs")
  private MsgsApiInstance msgs = null;

  public GeneralErrorResultApiInstance msgs(MsgsApiInstance msgs) {
    this.msgs = msgs;
    return this;
  }

  /**
   * Get msgs
   * @return msgs
   **/
  @Schema(description = "")
  
    @Valid
    public MsgsApiInstance getMsgs() {
    return msgs;
  }

  public void setMsgs(MsgsApiInstance msgs) {
    this.msgs = msgs;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    GeneralErrorResultApiInstance generalErrorResultApiInstance = (GeneralErrorResultApiInstance) o;
    return Objects.equals(this.msgs, generalErrorResultApiInstance.msgs);
  }

  @Override
  public int hashCode() {
    return Objects.hash(msgs);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class GeneralErrorResultApiInstance {\n");
    
    sb.append("    msgs: ").append(toIndentedString(msgs)).append("\n");
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
