package org.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Value;


@Value
@AllArgsConstructor
@Builder(toBuilder = true)
public class User {
    String id;
    String firstName;
    String lastName;
    int age;
}
