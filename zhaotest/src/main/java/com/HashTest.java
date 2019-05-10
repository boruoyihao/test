package com;


public class HashTest {
    public static void main(String[] args) {
//        System.out.println("paymentOrderNo20160425150245".compareTo("201706FI"));

//        Map<Student,String>map=new HashMap<Student,String>();
//
//        Student s1=new Student(12,"zhao");
//        map.put(s1,"d");
//        Student s2=new Student(13,"rr");
//        map.put(s2,"r");
//        System.out.println(map.get(new Student(12,"rr")));
//        System.out.println(map.get(s2));

        System.out.println("20180929143558505021610670005".length());
        System.out.println("20180929165212486026021610670033".length());
        System.out.println("30153820969900065602".length());
        System.out.println("20180929162909477027021610670009".length());

        System.out.println("20180929162909477027021610670009".substring(8,10));

        System.out.println("20180929181330519027021610670012");
        System.out.println(getRefundPaymentSeqNo("20180929181330519027021610670012"));
        String result=recoveryRefundOrderId(getRefundPaymentSeqNo("20180929181330519027021610670012"));
        System.out.println(result.equals("20180929181330519027021610670012"));

    }

    public static String recoveryRefundOrderId(String paymentSeqNo) {
        StringBuilder sb=new StringBuilder(32);
        sb.append(paymentSeqNo.substring(0,8));
        sb.append(paymentSeqNo.substring(9,18));
        sb.append("027");
        sb.append(paymentSeqNo.substring(18));
        return sb.toString();
    }

    public static String getRefundPaymentSeqNo(String refund) {
        StringBuilder sb=new StringBuilder();
        sb.append(refund.substring(0, 8));
        sb.append("R");
        sb.append(refund.substring(8, 17));
        sb.append(refund.substring(20));
        return sb.toString();
    }


    private static class Student{

        public Student(int age,String name){
            this.age=age;
            this.name=name;
        }
         int age;
         String name;

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return super.toString();
        }

        @Override
        public boolean equals(Object obj) {
            return true;
        }

        @Override
        public int hashCode() {
            return super.hashCode();
        }

        @Override
        protected Object clone() throws CloneNotSupportedException {
            return super.clone();
        }
    }
}