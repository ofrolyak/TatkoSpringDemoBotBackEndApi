package com.tatko.api.apis.models;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.tatko.api.apis.models.MsgApiInstance;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Msgs
 */
@Schema(description = "Msgs")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2024-10-20T17:36:38.774954200+03:00[Europe/Kiev]")


public class MsgsApiInstance   {
  @JsonProperty("msg")
  @Valid
  private List<MsgApiInstance> msg = null;

  public MsgsApiInstance msg(List<MsgApiInstance> msg) {
    this.msg = msg;
    return this;
  }

  public MsgsApiInstance addMsgItem(MsgApiInstance msgItem) {
    if (this.msg == null) {
      this.msg = new ArrayList<>();
    }
    this.msg.add(msgItem);
    return this;
  }

  /**
   * Get msg
   * @return msg
   **/
  @Schema(description = "")
      @Valid
    public List<MsgApiInstance> getMsg() {
    return msg;
  }

  public void setMsg(List<MsgApiInstance> msg) {
    this.msg = msg;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    MsgsApiInstance msgsApiInstance = (MsgsApiInstance) o;
    return Objects.equals(this.msg, msgsApiInstance.msg);
  }

  @Override
  public int hashCode() {
    return Objects.hash(msg);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class MsgsApiInstance {\n");
    
    sb.append("    msg: ").append(toIndentedString(msg)).append("\n");
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
