package com.guava.order;

import com.google.common.base.Function;
import com.google.common.collect.Ordering;
import com.google.common.primitives.Ints;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhaolizhen on 17-3-8.
 */
public class OrderTest {
    public static void main(String args[]){
        Ordering<String>ordering=new Ordering<String>() {
            @Override
            public int compare(String left, String right) {
                return Ints.compare(left.length(),right.length());
            }
        };

        List<String> list=new ArrayList<String>();
        list.add("abd");
        list.add("a");
        list.add("drrrr");
        list.add("rrrrrrr");
        list.sort(ordering);

        System.out.println(list);


        Ordering<Foo> ordering1 = Ordering.natural().nullsFirst().onResultOf(new Function<Foo, String>() {
            @Nullable
            @Override
            public String apply(Foo input) {
                return input.getSort();
            }
        });

        List<Foo> list2=new ArrayList<Foo>();
        list2.add(new Foo(null));
        list2.add(new Foo("abc"));
        list2.add(new Foo("a"));
        list2.add(new Foo("db"));
        list2.sort(ordering1);
        System.out.println(list2);

        Node node=Node.getNullNode().getRedNode();
        System.out.println();

        System.out.println(OO.a);

    }

}
class Foo{
    private String sort;
    public Foo(String sort){
        this.sort=sort;
    }
    public String getSort(){
        return sort;
    }

    @Override
    public String toString() {
        return "Foo{" +
                "sort='" + sort + '\'' +
                '}';
    }
}

 abstract class Node{


    public static Node getNullNode(){
        return NullNode.node;
    }

    public Node getRedNode(){
        return new RedNode(this);
    }

    public abstract void fun();
}


class NullNode extends Node{

    private NullNode(){

    }
    static final Node node=new NullNode();

    @Override
    public void fun() {
        System.out.println("NullNode");
    }
}

class RedNode extends Node{

    private Node node;

    public RedNode(Node node){
        this.node=node;
        node.fun();
    }

    @Override
    public void fun() {
        System.out.println("RedNode");
    }
}