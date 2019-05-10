package com.asm;

import net.sf.cglib.asm.MethodAdapter;
import net.sf.cglib.asm.MethodVisitor;
import net.sf.cglib.asm.Opcodes;

class ChangeToChildConstructorMethodAdapter extends MethodAdapter {
	private String superClassName;

	 public ChangeToChildConstructorMethodAdapter(MethodVisitor mv,
		 String superClassName) { 
		 super(mv); 
		 this.superClassName = superClassName; 
	 } 

	 public void visitMethodInsn(int opcode, String owner, String name, 
		 String desc) { 
		 // 调用父类的构造函数时
		 if (opcode == Opcodes.INVOKESPECIAL && name.equals("<init>")) {
			 owner = superClassName; 
		 } 
		 super.visitMethodInsn(opcode, owner, name, desc);// 改写父类为 superClassName 
	 } 
 }