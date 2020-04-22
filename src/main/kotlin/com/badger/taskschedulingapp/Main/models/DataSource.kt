package com.badger.taskschedulingapp.Main.models



import org.hibernate.Session
import org.hibernate.SessionFactory
import org.hibernate.boot.registry.StandardServiceRegistryBuilder
import org.hibernate.cfg.Configuration
import org.hibernate.cfg.Environment
import java.util.*

class DataSource {
    companion object {
        fun propertiesFromResource(resource: String): Properties {
            val properties = Properties()
            properties.load(Any::class.java.getResourceAsStream(resource))
            return properties
        }

        fun Properties.toHibernateProperties(): Properties {
            val hibernateProperties = Properties()
            hibernateProperties[Environment.DRIVER] = this["driver"]
            hibernateProperties[Environment.URL] = this["url"]
            hibernateProperties[Environment.USER] = this["user"]
            hibernateProperties[Environment.PASS] = this["pass"]
            hibernateProperties[Environment.DIALECT] = this["dialect"]
            hibernateProperties[Environment.SHOW_SQL] = this["showSql"]
            hibernateProperties[Environment.FORMAT_SQL] = this["formatSql"]
            hibernateProperties[Environment.CURRENT_SESSION_CONTEXT_CLASS] = this["currentSessionContextClass"]
            hibernateProperties[Environment.HBM2DDL_AUTO] = this["ddlAuto"]

            //C3PO
            hibernateProperties["hibernate.c3p0.min_size"] = this["hibernate.c3p0.min_size"]
            hibernateProperties["hibernate.c3p0.max_size"] = this["hibernate.c3p0.max_size"]
            hibernateProperties["hibernate.c3p0.timeout"] = this["hibernate.c3p0.timeout"]
            hibernateProperties["hibernate.c3p0.max_statements"] = this["hibernate.c3p0.max_statements"]

            return hibernateProperties
        }

        fun buildHibernateConfiguration(hibernateProperties: Properties, vararg annotatedClasses: Class<*>): Configuration {
            val configuration = Configuration()
            configuration.properties = hibernateProperties
            annotatedClasses.forEach { configuration.addAnnotatedClass(it) }
            return configuration
        }

        fun buildSessionFactory(configuration: Configuration): SessionFactory {
            val serviceRegistry = StandardServiceRegistryBuilder().applySettings(configuration.properties).build()
            return configuration.buildSessionFactory(serviceRegistry)
        }

        fun <T> SessionFactory.transaction(block: (session: Session) -> T): T {
            val session = openSession()
            val transaction = session.beginTransaction()

            return try {
                val rs = block.invoke(session)
                transaction.commit()
                rs
            } catch (e: Exception) {
                println("Transaction failed! Rolling back..." + e.toString())
                throw e
            }
        }

        fun addHibernateShutdownHook(sessionFactory: SessionFactory) {
            Runtime.getRuntime().addShutdownHook(object : Thread() {
                override fun run() {
                    println("Closing the sessionFactory...")
                    sessionFactory.close()
                    println("sessionFactory closed successfully...")
                }
            })
        }
    }
}