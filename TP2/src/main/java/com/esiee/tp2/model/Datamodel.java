package com.esiee.tp2.model;

import com.esiee.tp2.domain.Civility;
import com.esiee.tp2.domain.Function;
import com.esiee.tp2.domain.Person;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Datamodel {

    private static Datamodel instance;

    private Map<Long, Person> personMap = new HashMap<>();
    private Map<Long, Civility> civilityMap = new HashMap<>();
    private Map<Long, Function> functionMap = new HashMap<>();

    private Datamodel() {
        this.personMap = new HashMap<>();
        this.civilityMap = new HashMap<>();
        this.functionMap = new HashMap<>();

        //a test info
        Person p = new Person();
        p.setCivility(new Civility(123L));
        p.setFunction(new Function());
        p.setLogin("admin");
        p.setPassword("admin");

        personMap.put(p.getCivility().getId(), p);
    }

    public static synchronized Datamodel getInstance() {
        if (instance == null) {
            instance = new Datamodel();
        }
        return instance;
    }


    public List<Person> getPersons() {
        return new ArrayList<>(personMap.values());
    }

    public Person getPerson(Long id) {
        return personMap.get(id);
    }

    public List<Civility> getCivilities() {
        return new ArrayList<>(civilityMap.values());
    }

    public Civility getCivility(Long id) {
        return civilityMap.get(id);
    }

    public List<Function> getFunctions() {
        return new ArrayList<>(functionMap.values());
    }

    public Function getFunction(Long id) {
        return functionMap.get(id);
    }
}
