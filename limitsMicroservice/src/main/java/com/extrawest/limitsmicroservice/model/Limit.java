package com.extrawest.limitsmicroservice.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class Limit {
    private long id;
    private int min;
    private int max;
}
