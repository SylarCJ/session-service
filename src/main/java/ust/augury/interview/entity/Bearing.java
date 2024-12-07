package ust.augury.interview.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Bearing {

    private List<String> samples;

    private EndpointInfo endpointInfo;

    // Getters and Setters
}

