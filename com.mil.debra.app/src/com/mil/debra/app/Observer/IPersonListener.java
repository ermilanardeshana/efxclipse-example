package com.mil.debra.app.Observer;

import ch.makery.address.model.Person;

/**
 * Interface Listener to be implemented on controller class
 * 
 * @author Milan
 *
 */
public interface IPersonListener{

	void selectionChanged(Person person);
}
