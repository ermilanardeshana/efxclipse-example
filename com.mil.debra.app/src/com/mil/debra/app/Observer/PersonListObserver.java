package com.mil.debra.app.Observer;

import java.util.concurrent.CopyOnWriteArrayList;

import ch.makery.address.model.Person;

public class PersonListObserver {
	CopyOnWriteArrayList<IPersonListener> listeners = new CopyOnWriteArrayList<IPersonListener>();
	
	public static	PersonListObserver observer=new PersonListObserver();

	private PersonListObserver()
	{

	}
	public void register(IPersonListener personselectionListner){
		listeners.add(personselectionListner);	
	}

	public void select(Person person){
		for (IPersonListener ps : listeners){
			ps.selectionChanged(person);
		}
	}

}

