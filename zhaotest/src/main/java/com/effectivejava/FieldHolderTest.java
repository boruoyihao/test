package com.effectivejava;

/**
 * Created by zhaolizhen on 17-3-4.
 */
public class FieldHolderTest {

    public static void main(String args[]){
//        getField();
//        getField();
    }

    private static class FieldHolder{
        static final FieldType field=computeFieldType();

        private static FieldType computeFieldType() {
            System.out.println("computeFieldType");
            return new FieldType();
        }
    }

    static FieldType getField(){
        return FieldHolder.field;
    }

    private static class FieldType{

    }
}
