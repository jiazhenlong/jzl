package com.shop.task.base.akka;

import akka.actor.AbstractActor;
import akka.actor.Extension;
import akka.actor.Props;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

/**
 * An Akka Extension to provide access to Spring managed Actor Beans.
 */
@Component
public class SpringExtension implements Extension {

	private volatile ApplicationContext applicationContext;

	/**
	 * Used to initialize the Spring application context for the extension.
	 *
	 * @param applicationContext
	 */
	public void initialize(ApplicationContext applicationContext) {
		this.applicationContext = applicationContext;
	}

	/**
	 * Create a Props for the specified actorBeanName using the
	 * SpringActorProducer class.
	 *
	 * @param actorBeanName
	 *            The name of the actor bean to create Props for
	 * @return a Props that will create the named actor bean using Spring
	 */
	public Props props(String actorBeanName) {
		return Props.create(SpringActorProducer.class, applicationContext, actorBeanName);
	}

	/**
	 * Create a Props for the specified actorBeanName using the
	 * SpringActorProducer class.
	 *
	 * @param requiredType
	 *            Type of the actor bean must match. Can be an interface or
	 *            superclass of the actual class, or {@code null} for any
	 *            match. For example, if the value is {@code Object.class},
	 *            this method will succeed whatever the class of the
	 *            returned instance.
	 * @return a Props that will create the actor bean using Spring
	 */
	public Props props(Class<?> requiredType) {
		return Props.create(SpringActorProducer.class, applicationContext, requiredType);
	}

	/**
	 * Create a Props for the specified actorBeanName using the
	 * SpringActorProducer class.
	 *
	 * @param actorBeanName
	 *                The name of the actor bean to create Props for
	 * @param requiredType
	 *                Type of the actor bean must match. Can be an
	 *                interface or superclass of the actual class,
	 *                or {@code null} for any match. For example, if
	 *                the value is {@code Object.class}, this method
	 *                will succeed whatever the class of the
	 *                returned instance.
	 * @return a Props that will create the actor bean using Spring
	 */
	public Props props(String actorBeanName, Class<? extends AbstractActor> requiredType) {
		return Props.create(SpringActorProducer.class, applicationContext, actorBeanName, requiredType);
	}

	public Props props(String actorBeanName, Class<? extends AbstractActor> requiredType, Object ... constructArgs) {
		return Props.create(SpringActorProducer.class, applicationContext, actorBeanName, requiredType);
	}
}
