package ch.makery.address.model;

import java.security.Permissions;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class PersonListModel {

	private ObservableList<Person> personList = createList();
	private PersonListModel(){

	}

	private static PersonListModel instance  = new  PersonListModel();

	public static PersonListModel getInstance(){
		return  instance;
	}


	public static ObservableList<Person> createList(){
		ObservableList<Person> personData = FXCollections.observableArrayList();
		personData.add(new Person("Hans", "Muster"));
		personData.add(new Person("Ruth", "Mueller"));
		personData.add(new Person("Heinz", "Kurz"));
		personData.add(new Person("Cornelia", "Meier"));
		personData.add(new Person("Werner", "Meyer"));
		personData.add(new Person("Lydia", "Kunz"));
		personData.add(new Person("Anna", "Best"));
		personData.add(new Person("Stefan", "Meier"));
		personData.add(new Person("Martin", "Mueller"));
		return personData;
	}

	public void addPerson(Person person){
		if(!getPersonList().contains(person)){
			getPersonList().add(person);
		}

	}

	public void removePerson(Person person){
		if(getPersonList().contains(person)){
			getPersonList().remove(person);
		}

	}

	public ObservableList<Person> getPersonList() {
		return personList;
	}


	public void setPersonList(ObservableList<Person> personList) {
		this.personList = personList;
	}
}
