package com.badger.taskschedulingapp.Main.models


import org.hibernate.Session
import org.hibernate.SessionFactory
import org.hibernate.boot.registry.StandardServiceRegistryBuilder
import org.hibernate.cfg.Configuration
import org.hibernate.cfg.Environment
import java.io.Serializable
import java.util.*

class DataSource {
    companion object {
        /*Create returns property object created from located resource path*/
        private fun loadPropertiesFromResource(resource: String): Properties {
            val properties = Properties()
            properties.load(Any::class.java.getResourceAsStream(resource))
            return properties
        }

        /*Configures returns */
        private fun Properties.setHibernateProperties():Properties {
            val hibernateProperties = Properties()

            hibernateProperties[Environment.DRIVER] = this["driver"]
            hibernateProperties[Environment.URL] = this["url"]
            hibernateProperties[Environment.USER] = this["user"]
            hibernateProperties[Environment.PASS] = this["pass"]
            hibernateProperties[Environment.DIALECT] = this["dialect"]
            hibernateProperties[Environment.SHOW_SQL] = this["showSql"]
            hibernateProperties[Environment.FORMAT_SQL] = this["formatSql"]
            hibernateProperties[Environment.CURRENT_SESSION_CONTEXT_CLASS] = this["currentSessionContextClass"]
            hibernateProperties[Environment.HBM2DDL_AUTO] = this["HBM2DDLAuto"]
            hibernateProperties[Environment.C3P0_MIN_SIZE] = this["hibernate.c3p0.min_size"]
            hibernateProperties[Environment.C3P0_MAX_SIZE] = this["hibernate.c3p0.max_size"]
            hibernateProperties[Environment.C3P0_TIMEOUT] = this["hibernate.c3p0.timeout"]
            hibernateProperties[Environment.C3P0_MAX_STATEMENTS] = this["hibernate.c3p0.max_statements"]

            return hibernateProperties
        }

        /*creates hibernate configuration with given set hibernate properties and adds provided model classes*/
        private fun createHibernateConfig(hibernateProperties: Properties, vararg annotatedClasses: Class<*>): Configuration {
            val hibernateConfiguration = Configuration()
            hibernateConfiguration.properties = hibernateProperties
            annotatedClasses.forEach{hibernateConfiguration.addAnnotatedClass(it)}
            return hibernateConfiguration
        }

        /*returns SessionFactory build with provided configuration */
        private fun buildSessionFactory(hibernateConfiguration: Configuration): SessionFactory {
            val standardServiceRegistry = StandardServiceRegistryBuilder().applySettings(hibernateConfiguration.properties).build()
            return hibernateConfiguration.buildSessionFactory(standardServiceRegistry)
        }

        /*Uses current session to execute HQL query as a transaction*/
        fun <T> SessionFactory.transaction(sessionBlock: (session: Session) -> T): T {
            val session = currentSession
            val transaction = session.beginTransaction()

            return try{
                val sessionReturn = sessionBlock(session)
                transaction.commit()
                sessionReturn
            } catch (e: Exception) {
                println("Failed Transaction, unable to commit! $e")
                throw e
            }

        }

        /*Adds Runtime Shutdown Hook to close session factory.*/
        private fun addSessionFactoryShutdownHook(sessionFactory: SessionFactory) {
            Runtime.getRuntime().addShutdownHook(object: Thread() {
                override fun run() {
                    println("Closing SessionFactory!")
                    sessionFactory.close()
                    println("SessionFactory closed!")
                }
            })
        }

        /*configures and returns a completed SessionFactory object with a open session*/
        fun startSessionFactory(resource: String, modelsList: Array<Class<out Serializable>>): SessionFactory {
            val hibernateProperties =  loadPropertiesFromResource(resource).setHibernateProperties()
            val hibernateConfig = createHibernateConfig(hibernateProperties, *modelsList)
            val sessionFactory = buildSessionFactory(hibernateConfig)

            addSessionFactoryShutdownHook(sessionFactory)
            sessionFactory.openSession()    //pre-opens session for transactions to prevent multiple transactions per
                                            //single sessionFactory

            return sessionFactory
        }

    }
}