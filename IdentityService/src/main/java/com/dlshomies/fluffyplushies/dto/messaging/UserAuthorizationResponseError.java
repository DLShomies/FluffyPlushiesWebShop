package com.dlshomies.fluffyplushies.dto.messaging;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserAuthorizationResponseError {
    private Integer errorCode;
}