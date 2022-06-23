package com.sisCitas.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioDto {

   @NotNull
   @Size(min = 3, max = 8)
   private String usuario;

  // @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
   @NotNull
   @Size(min = 3, max = 6)
   private String password;

}