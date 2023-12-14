//package com.mergiu.QuickByteBE.domain.category;
//
//import jakarta.persistence.EntityManager;
//import jakarta.persistence.EntityManagerFactory;
//import jakarta.persistence.Persistence;
//import org.springframework.stereotype.Component;
//
//@Component
//public class CategoryFactory {
//
//    private static final EntityManagerFactory ENTITY_MANAGER_FACTORY = Persistence.createEntityManagerFactory("quickbytedb");//quickbytedb
//
//    private CategoryFactory() {
//    }
//
//    public static Category createCategory(String name, String description) {
//        Category category = new Category(name, description);
//
//        EntityManager entityManager = ENTITY_MANAGER_FACTORY.createEntityManager();
//        entityManager.getTransaction().begin();
//        entityManager.persist(category);
//        entityManager.getTransaction().commit();
//        entityManager.close();
//
//        return category;
//    }
//}
