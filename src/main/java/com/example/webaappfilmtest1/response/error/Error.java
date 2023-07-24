package com.example.webaappfilmtest1.response.error;

import com.example.webaappfilmtest1.response.constants.Code;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Error extends java.lang.Error {

    private Code code;
    private String userMessage;
    private String techMessage;
}
