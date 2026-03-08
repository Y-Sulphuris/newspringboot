package com.ydo4ki.newspringboot;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Схема пользователя, что тут непонятного")
public final class User {
    private Long id;
    private String name;
    private String address;
}
