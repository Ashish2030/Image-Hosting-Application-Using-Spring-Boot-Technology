package com.imagehoster.ImageHosterApplication.repository;
import com.imagehoster.ImageHosterApplication.model.Image;
import com.imagehoster.ImageHosterApplication.model.User;
import org.springframework.stereotype.Repository;
import javax.persistence.*;
import java.util.*;
@Repository
public class ImageRepository {
    @PersistenceUnit(unitName = "image")
    private EntityManagerFactory entityManagerFactory;

    public void createPost(Image newPost) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.persist(newPost);
            transaction.commit();
        } catch (Exception e) {
            System.out.println(e);
            transaction.rollback();
        }
    }
    public List<Image> getAllPosts(User user) {
        int a = user.getId();
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        TypedQuery<Image> query = entityManager.createQuery("SELECT p from Image p WHERE p.user = :user", Image.class);
        query.setParameter("user", user);
        List<Image> result = query.getResultList();
        return result;
    }
    public Image getImage(Integer postId) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        return entityManager.find(Image.class, postId);
    }
    public void updatePost(Image updatePost) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.merge(updatePost);
            transaction.commit();
        } catch (Exception e) {
            System.out.println(e);
            transaction.rollback();
        }
    }
    public void deletePost(Integer postId)
    {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            Image post = entityManager.find(Image.class, postId);

            entityManager.remove(post);
            transaction.commit();
        } catch (Exception e) {
            System.out.println(e);
            transaction.rollback();
        }
    }
}
