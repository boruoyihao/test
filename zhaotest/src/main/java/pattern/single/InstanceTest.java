package pattern.single;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by zhaolizhen on 18-5-2.
 */
public class InstanceTest {

    public static void main(String args[]) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        System.out.println(Instance.getInstance());

        Instance instance1=Instance.getInstance();

        Class<?>classType=Instance.class;
        Constructor<?>c=classType.getDeclaredConstructor(null);
        c.setAccessible(true);
        Instance instance2=(Instance)c.newInstance();

        new ConcurrentHashMap<String,String>();
    }
}
