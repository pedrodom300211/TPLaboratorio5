package frgp.utn.edu.ar.daoImp;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class ConfigHibernate {
    
    private SessionFactory sessionFactory;
    private Session session;
    
    public ConfigHibernate()
    {
        Configuration configuration = new Configuration();
        configuration.configure();    
        ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
    	sessionFactory = configuration.buildSessionFactory(serviceRegistry);
    	
    }
    
    public Session abrirConexion()
    {
        if (session == null || !session.isOpen()) {
            session = sessionFactory.openSession();
        }
        return session;
    }
    
    public void cerrarSession() {
        if (session != null && session.isOpen()) {
            session.close();
        }
        cerrarSessionFactory();
    }
    
    public void cerrarSessionFactory() {
        if (sessionFactory != null && !sessionFactory.isClosed()) {
            sessionFactory.close();
        }
    }

}



