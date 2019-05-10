package pattern.single;

public class Singleton {
    {
        System.out.println("Singleton");
    }
    private static class SingletonHolder {
         {
            System.out.println("SingletonHolder");
        }
    private static final Singleton INSTANCE = new Singleton();

    }  
    private Singleton (){}  
    public static final Singleton getInstance() {  
    return SingletonHolder.INSTANCE;  
    }

    public static void main(String args[]) throws IllegalAccessException, InstantiationException {

        Singleton singleton=new Singleton();
    }

}   