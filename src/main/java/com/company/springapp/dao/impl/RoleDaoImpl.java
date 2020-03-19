package com.company.springapp.dao.impl;

import com.company.springapp.dao.RoleDao;
import com.company.springapp.domain.Role;
import lombok.AllArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@AllArgsConstructor
public class RoleDaoImpl implements RoleDao {

    private SessionFactory sessionFactory;

    @Override
    public List<Role> findAll() {
        Session session = sessionFactory.getCurrentSession();
        Query<Role> query = session.createQuery("from Role", Role.class);
        return query.getResultList();
    }

    @Override
    public Optional<Role> getRole(long id) {
        Session session = sessionFactory.getCurrentSession();
        return Optional.ofNullable(session.get(Role.class, id));
    }

    @Override
    public void saveRole(Role role) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(role);
    }

    @Override
    public void deleteRole(long id) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("delete from Role where id=:roleId");
        query.setParameter("roleId", id);
        query.executeUpdate();
    }

}
