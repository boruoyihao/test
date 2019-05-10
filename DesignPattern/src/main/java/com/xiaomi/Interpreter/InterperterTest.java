package com.xiaomi.Interpreter;

public class InterperterTest {
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Expression expression1=new TerminalExpression("zhao");
        Expression expression2=new TerminalExpression("male");
        
        Expression zhaomaile=new AndExpression(expression1,expression2);
        
        Expression expression3=new TerminalExpression("jia");
        Expression expression4=new TerminalExpression("female");
        
        Expression jiafemail=new OrExpression(expression3,expression4);
        
        
        System.out.println(zhaomaile.interpret("male zhao"));
        
        System.out.println(jiafemail.interpret("jia"));
    }
    
}
