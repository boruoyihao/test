package com.asm;

import net.sf.cglib.asm.MethodAdapter;
import net.sf.cglib.asm.MethodVisitor;
import net.sf.cglib.asm.Opcodes;

class AddSecurityCheckMethodAdapter extends MethodAdapter {
	public AddSecurityCheckMethodAdapter(MethodVisitor mv) {
		 super(mv); 
	 } 

	 public void visitCode() { 
		 visitMethodInsn(Opcodes.INVOKESTATIC, "SecurityChecker",
			"checkSecurity", "()V"); 
	 } 
 }