package com.asm;

import net.sf.cglib.asm.ClassAdapter;
import net.sf.cglib.asm.ClassReader;
import net.sf.cglib.asm.ClassWriter;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class SecureAccountGenerator {

    private static AccountGeneratorClassLoader classLoader = 
        new AccountGeneratorClassLoader();
    
    private static Class secureAccountClass; 
    
    public Student generateSecureAccount() throws ClassFormatError,
            InstantiationException, IllegalAccessException, IOException {
        if (null == secureAccountClass) {            
            ClassReader cr = new ClassReader("com.asm.Student");
            ClassWriter cw = new ClassWriter(ClassWriter.COMPUTE_MAXS);
            ClassAdapter classAdapter = new AddSecurityCheckClassAdapter(cw);
            cr.accept(classAdapter, ClassReader.SKIP_DEBUG);
            byte[] data = cw.toByteArray();
//            File file = new File("Student$EnhancedByASM.class");
//            FileOutputStream fout = new FileOutputStream(file);
//            fout.write(data);
//            fout.close();
            secureAccountClass = classLoader.defineClassFromClassFile(
               "Student$EnhancedByASM",data);
        } 
        return (Student) secureAccountClass.newInstance();
    } 
    
    private static class AccountGeneratorClassLoader extends ClassLoader {
        public Class defineClassFromClassFile(String className, 
            byte[] classFile) throws ClassFormatError { 
            return defineClass("Student$EnhancedByASM", classFile, 0,
                    classFile.length);
        } 
    }

    public static void main(String args[]) throws IllegalAccessException, IOException, InstantiationException {
        SecureAccountGenerator generator=new SecureAccountGenerator();
        generator.generateSecureAccount();
    }
}
