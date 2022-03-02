package ss23_Behavioral_Design_Pattern.Thuc_hanh.Observer;

import javax.security.auth.Subject;

abstract class Observer {
    protected Subject subject;
    public abstract void update();
}
