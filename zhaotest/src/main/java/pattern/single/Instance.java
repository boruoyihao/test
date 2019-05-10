package pattern.single;

import java.io.ObjectStreamException;
import java.io.Serializable;

/**
 * Created by zhaolizhen on 18-5-2.
 */
class Instance implements Serializable{
    private static boolean flag=false;

    private Instance(){
        System.out.println("Instance init");
        synchronized (Instance.class){
            if(flag==false){
                flag=!flag;
            }else{
                throw new RuntimeException("Instance can't be instanced");
            }
        }
    }

    private static class InstanceHolder{
        private static Instance instance=new Instance();
    }

    public static Instance getInstance(){
        return InstanceHolder.instance;
    }

    private Object readResolve() throws ObjectStreamException{
        return InstanceHolder.instance;
    }

}
