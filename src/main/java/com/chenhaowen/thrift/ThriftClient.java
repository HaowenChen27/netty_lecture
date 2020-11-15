package com.chenhaowen.thrift;

import org.apache.thrift.protocol.TCompactProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TFramedTransport;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;
import thrift.generated.Person;
import thrift.generated.PersonService;

/**
 * @author chenhaowen
 * @Description:
 * @date 2020/11/15 7:00 下午
 */
public class ThriftClient {

    public static void main(String[] args) {
        TTransport transport = new TFramedTransport(new TSocket("localhost", 8899), 600);
        TProtocol protocol = new TCompactProtocol(transport);
        PersonService.Client client = new PersonService.Client(protocol);

        try {
            transport.open();

            Person person = client.getPersonByUserName("张三");

            System.out.println(person.getUsername());
            System.out.println(person.getAge());
            System.out.println(person.isMarried());

            System.out.println("--------------");

            Person person1 = new Person();
            person1.setUsername("李四");
            person1.setAge(30);
            person1.setMarried(true);
            client.savePerson(person1);

        }catch (Exception exception) {
            throw new RuntimeException(exception.getMessage(), exception);
        }finally {
            transport.close();
        }
    }
}
