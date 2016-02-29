package com.mil.debra.app.Observer;

import java.util.concurrent.CopyOnWriteArrayList;

import ch.makery.address.model.Person;

/**
 * Observer pattern class.
 * This class observes on Person List Model. 
 * 
 * @author Milan
 *
 */
public class PersonListObserver {
	CopyOnWriteArrayList<IPersonListener> listeners = new CopyOnWriteArrayList<IPersonListener>();
	
	public static PersonListObserver observer=new PersonListObserver();

	private PersonListObserver()
	{

	}
	public void register(IPersonListener personselectionListner){
		listeners.add(personselectionListner);	
	}
	
	public void unregister(IPersonListener personselectionListner){
		listeners.remove(personselectionListner);
	}

	public void select(Person person){
		for (IPersonListener ps : listeners){
			ps.selectionChanged(person);
		}
	}

}

