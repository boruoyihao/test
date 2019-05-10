package com.proxy;


import net.sf.cglib.asm.ClassAdapter;
import net.sf.cglib.asm.ClassVisitor;
import net.sf.cglib.asm.MethodVisitor;

/**
 * Created by zhaolizhen on 17-3-21.
 */
public class DelLoginClassAdapter extends ClassAdapter{

    public DelLoginClassAdapter(ClassVisitor classVisitor) {
        super(classVisitor);
    }

    @Override
    public MethodVisitor visitMethod(int i, String s, String s1, String s2, String[] strings) {
        if(s.equals("getAge")){
            return null;
        }
        return super.visitMethod(i, s, s1, s2, strings);
    }
}
