package com.newsquawk.calendar.service;

import com.newsquawk.calendar.model.Category;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import static javax.transaction.Transactional.TxType.REQUIRED;
import static javax.transaction.Transactional.TxType.REQUIRES_NEW;

@ApplicationScoped
public class CategoryService {
    private static final Logger logger = Logger.getLogger(EventService.class.getName());

    @Inject
    protected EntityManager em;

    private EntityManager getEntityManager() {
        return em;
    }

    public List<Category> findAll() {
        return new ArrayList<Category>(); // TODO SQL
    }

    @Transactional(REQUIRED)
    public void create(Category category) {
        getEntityManager().persist(category);
    }

    @Transactional(REQUIRES_NEW)
    public Category edit(Category category) {
        return em.merge(category);
    }

    @Transactional(REQUIRED)
    public void remove(Category category) {
        getEntityManager().remove(category);
    }
}
