package javaBean;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

class StudentBeanListener implements PropertyChangeListener {
    public void propertyChange(PropertyChangeEvent event) {
        System.out.println("oldvalue = " + event.getOldValue() + " newValue = " + event.getNewValue());
    }

}

public class MainBean {
    public static void main(String[] args) {
        StudentBean studentBean = new StudentBean();
        // add event to studentBean object
        // after adding StudentBeanListener we can see what changes actually  are with objects
        studentBean.addPropertyChangeSupport(new StudentBeanListener());
        // set method will automatically invoke firePropertyChage();
        studentBean.setName("suraj");
        studentBean.setAge(23);
        studentBean.setName("Alan");
        studentBean.setAge(24);
        studentBean.setName("Anil");
        studentBean.setAge(9);
    }
}