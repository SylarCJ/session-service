package ust.augury.interview.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Component {

    private String id;

    private String type;

    private List<Bearing> bearings;

}
