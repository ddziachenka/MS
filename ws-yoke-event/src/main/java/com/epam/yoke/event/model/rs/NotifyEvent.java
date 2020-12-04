package com.epam.yoke.event.model.rs;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class NotifyEvent {

/*  public String eventId;
  public List<String> emails;
  public String description;*/

    public String id;
    public String eventId;
    public List<String> emails;
    public String description;
}
