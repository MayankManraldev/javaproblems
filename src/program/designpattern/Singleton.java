package program.designpattern;

import java.io.Serializable;

public class Singleton implements Cloneable, Serializable {
    private static  Singleton instance=null;
    private Singleton(){
        System.out.println("Inside Singleton contructor");
        if(instance!=null)
            throw new IllegalArgumentException();
    }

    protected Object readResolve() {
        return instance;
    }

    public static Singleton getInstance(){
        if (instance == null)
        synchronized (Singleton.class){
            if(instance==null)
                instance = new Singleton();
        }
        return instance;
    }

    @Override
    public Singleton clone() throws CloneNotSupportedException {
         throw new CloneNotSupportedException();
    }


}
