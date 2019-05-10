package com.asm;

import net.sf.cglib.asm.ClassAdapter;
import net.sf.cglib.asm.ClassVisitor;
import net.sf.cglib.asm.MethodVisitor;

class AddSecurityCheckClassAdapter extends ClassAdapter {

    public AddSecurityCheckClassAdapter(ClassVisitor cv) {
        //Responsechain 的下一个 ClassVisitor，这里我们将传入 ClassWriter，
        // 负责改写后代码的输出
        super(cv); 
    }

    @Override
    public void visit(int i, int i1, String s, String s1, String s2, String[] strings) {
        String enhancedName = s + "$EnhancedByASM";  // 改变类命名
        String enhancedSuperName = s; // 改变父类，这里是”Account”
        super.visit(i, i1, enhancedName, s1, enhancedSuperName, strings);
    }

    // 重写 visitMethod，访问到 "operation" 方法时，
    // 给出自定义 MethodVisitor，实际改写方法内容
    @Override
    public MethodVisitor visitMethod(final int access, final String name,
        final String desc, final String signature, final String[] exceptions) { 
        MethodVisitor mv = cv.visitMethod(access, name, desc, signature,exceptions);
        MethodVisitor wrappedMv = mv; 
        if (mv != null) { 
            // 对于 "operation" 方法
            if (name.equals("getAge")) {
                // 使用自定义 MethodVisitor，实际改写方法内容
                wrappedMv = new AddSecurityCheckMethodAdapter(mv); 
            } else if (name.equals("<init>")) {
                wrappedMv = new ChangeToChildConstructorMethodAdapter(mv,
                        name);
            }
        } 
        return wrappedMv; 
    } 
}