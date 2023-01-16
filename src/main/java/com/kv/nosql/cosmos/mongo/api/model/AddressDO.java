package com.kv.nosql.cosmos.mongo.api.model;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@ToString
public class AddressDO {
    @NonNull
    private String address1, address2, city, state, zipcode;
}
