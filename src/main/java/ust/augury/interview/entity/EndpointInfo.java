package ust.augury.interview.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EndpointInfo {

    private String type;

    private int installationPlane;

    private Version versions;
}

