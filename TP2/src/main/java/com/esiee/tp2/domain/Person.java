package com.esiee.tp2.domain;

public class Person {
    private Long id; // 如果有 id 的话
    private String login;
    private String password;

    // 关联对象（根据类图中的连线关系）
    private Civility civility;
    private Function function;

    public Person() {

    }

    public Long getId(){
        return this.civility.getId();
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Civility getCivility() {
        return civility;
    }

    public void setCivility(Civility civility) {
        this.civility = civility;
    }

    public Function getFunction() {
        return function;
    }

    public void setFunction(Function function) {
        this.function = function;
    }
}