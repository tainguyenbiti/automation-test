package com.acblogictics.databaseabclogictics.service.dto;

import lombok.*;

import java.io.Serializable;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDto implements Serializable {
    Long id;
    String username;
}