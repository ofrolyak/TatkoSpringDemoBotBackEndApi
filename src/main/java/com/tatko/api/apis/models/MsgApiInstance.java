package com.tatko.api.apis.models;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * MsgApiInstance
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2024-10-20T17:36:38.774954200+03:00[Europe/Kiev]")


public class MsgApiInstance   {
  @JsonProperty("type")
  private String type = null;

  @JsonProperty("code")
  private String code = null;

  @JsonProperty("text")
  private String text = null;

  @JsonProperty("dest")
  private String dest = null;

  public MsgApiInstance type(String type) {
    this.type = type;
    return this;
  }

  /**
   * Get type
   * @return type
   **/
  @Schema(description = "")
  
    public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public MsgApiInstance code(String code) {
    this.code = code;
    return this;
  }

  /**
   * Get code
   * @return code
   **/
  @Schema(description = "")
  
    public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public MsgApiInstance text(String text) {
    this.text = text;
    return this;
  }

  /**
   * Get text
   * @return text
   **/
  @Schema(description = "")
  
    public String getText() {
    return text;
  }

  public void setText(String text) {
    this.text = text;
  }

  public MsgApiInstance dest(String dest) {
    this.dest = dest;
    return this;
  }

  /**
   * Get dest
   * @return dest
   **/
  @Schema(description = "")
  
    public String getDest() {
    return dest;
  }

  public void setDest(String dest) {
    this.dest = dest;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    MsgApiInstance msgApiInstance = (MsgApiInstance) o;
    return Objects.equals(this.type, msgApiInstance.type) &&
        Objects.equals(this.code, msgApiInstance.code) &&
        Objects.equals(this.text, msgApiInstance.text) &&
        Objects.equals(this.dest, msgApiInstance.dest);
  }

  @Override
  public int hashCode() {
    return Objects.hash(type, code, text, dest);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class MsgApiInstance {\n");
    
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    code: ").append(toIndentedString(code)).append("\n");
    sb.append("    text: ").append(toIndentedString(text)).append("\n");
    sb.append("    dest: ").append(toIndentedString(dest)).append("\n");
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
