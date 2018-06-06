package com.example.mayn.myapp.bean;

/**
 * Created by shuqinggang on 2018/6/5.
 * 设计模式 builder模式
 */

public class PersonBean {
    private String name;
    private String age;
    private double height;
    private double weight;

    private PersonBean(Builder builder){
        this.name=builder.name;
        this.age=builder.age;
        this.height=builder.height;
        this.weight=builder.weight;
    }
    private PersonBean(){

    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }
    public static class Builder{
        private String name;
        private String age;
        private double height;
        private double weight;

        public Builder name(String name){
            this.name=name;
            return this;
        }
        public Builder age(String age){
            this.age=age;
            return this;
        }
        public Builder height(double height){
            this.height=height;
            return this;
        }
        public Builder weight(double weight){
            this.weight=weight;
            return this;
        }

        public PersonBean build(){
            return new PersonBean(this);
        }
    }
}
