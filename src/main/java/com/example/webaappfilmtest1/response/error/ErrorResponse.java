package com.example.webaappfilmtest1.response.error;

import com.example.webaappfilmtest1.response.Response;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ErrorResponse implements Response {
    private java.lang.Error error;
}
