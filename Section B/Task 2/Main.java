package com.jatin;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.jatin.model.MenuItem;
import com.jatin.model.Restaurant;

public class Main {

    public static void main(String[] args) {

        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");

        SessionFactory factory = configuration.buildSessionFactory();

        Session session = factory.openSession();

        Restaurant restaurant =
                new Restaurant("Food Palace", "Ahmedabad", 4.5);

        MenuItem item1 =
                new MenuItem("Paneer Pizza", 250, true);

        MenuItem item2 =
                new MenuItem("Veg Burger", 150, true);

        MenuItem item3 =
                new MenuItem("Cold Coffee", 100, true);

        item1.setRestaurant(restaurant);
        item2.setRestaurant(restaurant);
        item3.setRestaurant(restaurant);

        restaurant.getMenuItems().add(item1);
        restaurant.getMenuItems().add(item2);
        restaurant.getMenuItems().add(item3);

        session.beginTransaction();

        session.persist(restaurant);

        session.getTransaction().commit();

        String name = "Food Palace";

        List<MenuItem> items = session.createQuery(
                "FROM MenuItem WHERE restaurant.name = :name",
                MenuItem.class)
                .setParameter("name", name)
                .getResultList();

        for (MenuItem item : items) {
            System.out.println(
                    item.getItemName() + " - "
                    + item.getPrice() + " - "
                    + item.isAvailable());
        }

        session.close();
        factory.close();
    }
}