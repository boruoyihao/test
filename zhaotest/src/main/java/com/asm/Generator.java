package com.asm;

import java.io.File;
 import java.io.FileOutputStream;

import net.sf.cglib.asm.ClassAdapter;
import net.sf.cglib.asm.ClassReader;
import net.sf.cglib.asm.ClassWriter;

public class Generator{
	 public static void main(String args[]) throws Exception {
		 ClassReader cr = new ClassReader("com.asm.Student");
		 ClassWriter cw = new ClassWriter(ClassWriter.COMPUTE_MAXS);
		 ClassAdapter classAdapter = new AddSecurityCheckClassAdapter(cw);
		 cr.accept(classAdapter, ClassReader.SKIP_DEBUG); 
		 byte[] data = cw.toByteArray(); 
		 File file = new File("Student.class");
		 FileOutputStream fout = new FileOutputStream(file);
		 fout.write(data); 
		 fout.close(); 
	 } 
 }

