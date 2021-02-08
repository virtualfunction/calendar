package com.newsquawk.calendar.resource;

import com.newsquawk.calendar.model.Event;
import com.newsquawk.calendar.service.EventService;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;

@RequestScoped
@Path("/events")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class EventResource {

    @Inject
    protected EventService eventService;

    @POST
    public Event addEvent(Event event) { // TODO: Do I need to extract out path param, or should be able to post raw JSON in the body?
        eventService.create(event);
        return event; // Need to return HTTP created rather than "OK"
    }

    @GET
    @Path("/{id}")
    public Event getEvent(@PathParam("id") Long id) {
        return eventService.find(id);
    }

    // TODO: Make this build up a criteria
    @GET
    public List<Event> listEvents() {
        return eventService.findAll();
    }

}
