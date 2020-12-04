package com.epam.yoke.notify.mapper;

import com.epam.yoke.notify.model.Event;
import com.epam.yoke.notify.model.Report;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ReportMapper {

    @Mapping(target = "eventId", source = "eventId")
    Report mapEvent(Event source);

    List<Report> mapEvents(List<Event> events);
}
