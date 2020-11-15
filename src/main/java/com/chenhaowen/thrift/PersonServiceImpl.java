package com.chenhaowen.thrift;

import org.apache.thrift.TException;
import thrift.generated.DataException;
import thrift.generated.Person;
import thrift.generated.PersonService;

/**
 * @author chenhaowen
 * @Description:
 * @date 2020/11/15 6:49 下午
 */
public class PersonServiceImpl implements PersonService.Iface {

    @Override
    public Person getPersonByUserName(String username) throws DataException, TException {
        System.out.println("Get Client Param: " + username);
        Person person = new Person();
        person.setAge(10);
        person.setUsername(username);
        person.setMarried(false);
        return person;
    }

    @Override
    public void savePerson(Person person) throws DataException, TException {
        System.out.println("Got Client Param");
        System.out.println(person.getUsername());
        System.out.println(person.getAge());
        System.out.println(person.isMarried());
    }
}
