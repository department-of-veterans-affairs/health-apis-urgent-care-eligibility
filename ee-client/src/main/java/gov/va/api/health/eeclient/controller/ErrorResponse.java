package gov.va.api.health.eeclient.controller;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/** The error response is the payload returned to the caller should a failure occur. */
@JsonDeserialize(builder = ErrorResponse.ErrorResponseBuilder.class)
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@XmlRootElement(name = "error")
@XmlAccessorType(XmlAccessType.FIELD)
public class ErrorResponse {
  long timestamp;
  String type;
  String message;

  /** Create a new error response based on the given exception. */
  public static ErrorResponse of(@NonNull Exception e) {
    return ErrorResponse.builder()
        .timestamp(System.currentTimeMillis())
        .type(e.getClass().getSimpleName())
        .message(e.getMessage())
        .build();
  }
}
