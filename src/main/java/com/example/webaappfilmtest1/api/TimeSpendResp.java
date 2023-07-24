package com.example.webaappfilmtest1.api;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TimeSpendResp {
    private long filmCount;
    private int spendingTime;
}
