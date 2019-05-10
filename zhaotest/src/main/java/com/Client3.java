package com;

import java.io.*;
import java.lang.reflect.Constructor;

/**
 * 静态内部类实现方式（也是一种懒加载方式）
 * 这种方式：线程安全，调用效率高，并且实现了延迟加载
 * 解决反射和反序列化漏洞
 *
 * @author Shearer
 */
class SingletonDemo7 implements Serializable {

    private static class SingletonClassInstance {
        private static final SingletonDemo7 instance = new SingletonDemo7();
    }

    // 方法没有同步，调用效率高
    public static SingletonDemo7 getInstance() {
        return SingletonClassInstance.instance;
    }

    // 防止反射获取多个对象的漏洞
    private SingletonDemo7() {
        if (null != SingletonClassInstance.instance)
            throw new RuntimeException();
    }

    // 防止反序列化获取多个对象的漏洞
    private Object readResolve() throws ObjectStreamException {
        return SingletonClassInstance.instance;
    }
}

public class Client3 {

    public static void main(String[] args) throws Exception {
        SingletonDemo7 sc1 = SingletonDemo7.getInstance();
        SingletonDemo7 sc2 = SingletonDemo7.getInstance();
        System.out.println(sc1); // sc1，sc2是同一个对象
        System.out.println(sc2);

        // 通过反射的方式直接调用私有构造器（通过在构造器里抛出异常可以解决此漏洞）
        Class<SingletonDemo7> clazz = (Class<SingletonDemo7>) Class.forName("com.SingletonDemo7");
        Constructor<SingletonDemo7> c = clazz.getDeclaredConstructor(null);
        c.setAccessible(true); // 跳过权限检查
        SingletonDemo7 sc3 = c.newInstance();
        SingletonDemo7 sc4 = c.newInstance();
        System.out.println("通过反射的方式获取的对象sc3：" + sc3);  // sc3，sc4不是同一个对象
        System.out.println("通过反射的方式获取的对象sc4：" + sc4);

        // 通过反序列化的方式构造多个对象（类需要实现Serializable接口）

        // 1. 把对象sc1写入硬盘文件
        FileOutputStream fos = new FileOutputStream("object.out");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(sc1);
        oos.close();
        fos.close();

        // 2. 把硬盘文件上的对象读出来
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("object.out"));
        SingletonDemo7 sc5 = (SingletonDemo7) ois.readObject();
        // 反序列化出来的对象，和原对象，不是同一个对象。如果对象定义了readResolve()方法，可以解决此问题。
        System.out.println("对象定义了readResolve()方法，通过反序列化得到的对象：" + sc5);
        ois.close();
    }

}
