// steps for implementing java beans
/*
 * Step 1: First declare Public Java class (Student Bean);
 * Step 2: Declare variable using private keyword (name,age,propertyChangeSupport) most consider encaptulation;
 * Step 3: Declared getter(getName,getAge) and setter(setName,getAge) for Each variable to access private varibale;
 * Step 4: Import java.beans.PropertyChangeListener and java.beans.PropertyChangeSupport to  use Event of java;
 *         a)java.beans.PropertyChangeSupport:
 *              Store all the data(variable) through properties have passed 
 *              Stroe data changes like old value and new Value
 *              Use Event to Invoke;
 *         b)java.beans.PropertyChangeListener:
 *              Contain event for adding and removing properties  from PropertyChangeSupport
 * Step 5: Set propertyChnageSupport varible with new instance of PropertyChangeSupport by binding with this keyword on a class constructor;
 * Step 6: In setter method propertyChnageSupport.firePropertyChange("any name",oldValue,newValue);
 * Step 7: Create Method to addLister and removeLister from propertyChangeSupport 
 * Step 8: Create a class (StudentBeanListener) which implements PropertyChangeListener
 * Step 9: Import java.beans.PropertyChangeEvent and java.beans.PropertyChangeListener;
 *         a)java.beans.PropertyChangeEvent:
 *              Conatains event which store old and new value of data changed(variable)
 * Step 10: construct  method to overide implemented interface by PropertyChange(PropertyChangeEvent event)
 *          event is responsible for giving old value by event.getOldValue() and new value By event.getNewValue()
 * Step 11:Create instance studentBean inside  main  method of your class
 * Step 12: Add addPropertyChangeSupport to instance(studentBean)for using event;
 * Step 13: Invoke setter method  to set value ;
 * step 14: after setter method invoke it will directly invoke firePropertyChangeMethod added to PropertyChangeSupport
 * Step 15: Compile and Run;
 */ 



package javaBean;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;

public class StudentBean implements Serializable {
    // declaring private variable
    private String name;
    private int age;
    // created instance of PropertyChangeSupport  to bind with whole class using contructour;
    private PropertyChangeSupport propertyChangeSupport;

    // binding propertChangeSupport by using constructor this refrence of whole class;
    public StudentBean() {
        propertyChangeSupport = new PropertyChangeSupport(this);
    }
    // getter setter for name
    public void setName(String name) {
        String oldName = this.name;
        this.name = name;
        // have added fire event to propertyChangeSupport insatnce it invokes when set method run;
        // this value will pass pass to propertyChange(PropertyChangeEvent event) method;
        propertyChangeSupport.firePropertyChange("name", oldName, name);
        // in that method we can invoke event.getOldValue() and event.getNewValue() to recive modify value of varible
    }

    public String getName() {
        return this.name;
    }
    // getter setter for age
    public void setAge(int age) {
        int oldAge = this.age;
        this.age = age;
        propertyChangeSupport.firePropertyChange("age", oldAge, age);
    }

    public int getAge() {
        return this.age;
    }
    // this two methods  are for adding and removing event;
    public void addPropertyChangeSupport(PropertyChangeListener listener) {
        propertyChangeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        propertyChangeSupport.removePropertyChangeListener(listener);
    }
}
