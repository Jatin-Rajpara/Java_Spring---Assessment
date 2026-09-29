package com.jatin.dao;

import java.util.List;

import org.hibernate.Session;

import com.jatin.model.Restaurant;
import com.jatin.util.HibernateUtil;

public class RestaurantDAO {

    public List<Restaurant> getAllRestaurants() {

        Session session =
                HibernateUtil.getSessionFactory().openSession();

        List<Restaurant> restaurants = session.createQuery(
                "FROM Restaurant",
                Restaurant.class
        ).getResultList();

        session.close();

        return restaurants;
    }
}