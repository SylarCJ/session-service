package ust.augury.interview.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
public class Session {

    private String id;

    private String userId;

    private String machineId;

    private List<Component> components;

    @JsonProperty("createdAt")
    private Date createdAt;

    @JsonProperty("updatedAt")
    private Date updatedAt;

    private boolean continuous;

    private String status;

    @JsonProperty("statusUpdatedAt")
    private Date statusUpdatedAt;

    private boolean enableInterim;

    private List<String> tags;
}

