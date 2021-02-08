package com.newsquawk.calendar.service;

import com.newsquawk.calendar.model.Event;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import org.hibernate.Session;


import static javax.transaction.Transactional.TxType.REQUIRED;
import static javax.transaction.Transactional.TxType.REQUIRES_NEW;

@ApplicationScoped
public class EventService {
    private static final Logger logger = Logger.getLogger(EventService.class.getName());

    @Inject
    protected EntityManager em;

    private EntityManager getEntityManager() {
        return em;
    }

    // TODO: Add date ranges, etc, etc
    public List<Event> findAll() {
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<Event> query = builder.createQuery(Event.class);
        query.select(query.from(Event.class));
        return em.createQuery(query).getResultList();
    }

    public Event find(Long id) {
        return (Event)getEntityManager()
                .createNamedQuery("Event.findByID", Event.class)
                .setParameter("id", id)
                .setMaxResults(1)
                .getSingleResult();
    }

    @Transactional(REQUIRED)
    public void create(Event event) {
        getEntityManager().persist(event);
    }

    @Transactional(REQUIRES_NEW)
    public Event edit(Event event) {
        return em.merge(event);
    }

    @Transactional(REQUIRED)
    public void remove(Event event) {
        getEntityManager().remove(event);
    }
}
