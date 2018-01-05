package cn.g2link.web.reports.model.repository;

import cn.g2link.web.reports.model.entity.User;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class UserRepository implements IUserRepository {

    @Autowired
    private SessionFactory sessionFactory;


    private Session getSession(){
        return sessionFactory.getCurrentSession();
    }

    @Override
    public User findUserById(Integer id) {
        Query query= getSession().createQuery("from User where id = ?");
        query.setParameter(0, id);
        return (User) query.list().get(0);
    }
}
