package com.ademozalp.hibernate.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class CountByName {
    private String name;
    private long count;


}
