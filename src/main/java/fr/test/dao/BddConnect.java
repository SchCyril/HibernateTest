package fr.test.dao;

import fr.test.Article;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class BddConnect implements IntBddConnect {


    @Override
    public void lister() {

        try {

            EntityManager entityManager = JpaUtils.getEntityManagerFactory().createEntityManager();

            List<Article> articles = entityManager.createQuery("from Article", Article.class).getResultList();
            articles.forEach(System.out::println);

            entityManager.close();

        } finally {
            if (JpaUtils.getEntityManagerFactory() != null) JpaUtils.shutdown();
        }

    }

    @Override
    public void remove() {
        try {
            EntityManager entityManager = JpaUtils.getEntityManagerFactory().createEntityManager();
            entityManager.getTransaction().begin();

            Article article = entityManager.createQuery("from Article where idArticle = 13", Article.class).getSingleResult();
            entityManager.remove(article);

            List<Article> articles = entityManager.createQuery("from Article", Article.class).getResultList();
            articles.forEach(System.out::println);

            entityManager.getTransaction().commit();

            entityManager.close();
        } finally {
            if (JpaUtils.getEntityManagerFactory() != null) JpaUtils.shutdown();
        }
    }

    @Override
    public void ajouter(Article article) {

        try {
            EntityManager entityManager = JpaUtils.getEntityManagerFactory().createEntityManager();
            entityManager.getTransaction().begin();

            Query sql = entityManager.createQuery("from Article a where a.idArticle =:idArticle", Article.class);
            sql.setParameter("idArticle", 1);

            List<Article> articles = entityManager.createQuery("from Article", Article.class).getResultList();
            articles.forEach(System.out::println);

            entityManager.getTransaction().commit();

            entityManager.close();
        } finally {
            if (JpaUtils.getEntityManagerFactory() != null) JpaUtils.shutdown();
        }
    }

}
