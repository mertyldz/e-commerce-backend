package com.allianz.example.controller;

import com.allianz.example.model.Person;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("example")
public class ExampleController {
    // Endpoint -> Son nokta-Bitiş noktası. Rest servis yazıyorsam, endpoint bunu kullanıcıya sunduğum nokta
    // localhost:8080/example pathi bir endpointtir. browserdan veya postman'den tetikleniyor. yani URL
    // HER API'ımız bir method.
    // Request mapping verdiğimiz için, tüm controller'a path vermiş olduk.
    // Tüm api pathleri example/ ile başlar. localhost:8080/example/person gibi.

    @GetMapping("hello-world")
    public ResponseEntity<String> helloWorldApi() {
        return new ResponseEntity<>("Hello world", HttpStatus.ACCEPTED);
    }

    @GetMapping("person")
    public ResponseEntity<Person> personApi() {
        Person person = new Person();
        person.setName("Furkan");
        person.setSurname("Yalçın");
        person.setBirthYear(1992);
        person.setTc("asdasdasd");
        return new ResponseEntity<>(person, HttpStatus.OK);
    }

    // Path variable. localhost:8080/person/ sonrasında bir parametre almak istiyorsak kullanılıyor.
    // Parametre olarak mapdeki ile aynı olmak zorunda!
    @GetMapping("person/{personId}")
    public ResponseEntity<Person> personGetPersonByIdApi(@PathVariable int personId) {
        if (personId == 1) {
            Person person = new Person();
            person.setName("Furkan");
            person.setSurname("Yalçın");
            person.setBirthYear(1992);
            person.setTc("asdasdasd");
            return new ResponseEntity<>(person, HttpStatus.OK);
        } else {
            Person person = new Person();
            person.setName("Gizem");
            person.setSurname("Kısa");
            person.setBirthYear(1992);
            person.setTc("zxczxcasd");
            return new ResponseEntity<>(person, HttpStatus.OK);
        }
    }

    @GetMapping("person-list")
    public ResponseEntity<List<Person>> personGetPersonByIdApi() {
        List<Person> personList = new ArrayList<>();

        Person person1 = new Person();
        person1.setName("Furkan");
        person1.setSurname("Yalçın");
        person1.setBirthYear(1992);
        person1.setTc("asdasdasd");

        Person person2 = new Person();
        person2.setName("Gizem");
        person2.setSurname("Kısa");
        person2.setBirthYear(1992);
        person2.setTc("zxczxcasd");

        personList.add(person1);
        personList.add(person2);

        return new ResponseEntity<>(personList, HttpStatus.OK);
    }

    // Request parameter. URL'e parametre göndererek çalışır. person-by-request-param?personId=2&personName=Mert gibi.
    @GetMapping("person-by-request-param")
    public ResponseEntity<Person> getPersonByIdRequestParamApi(@RequestParam int personId, @RequestParam String tc) {
        System.out.println(tc);
        Person person = new Person();
        if (personId == 1) {
            person.setName("Furkan");
            person.setSurname("Yalçın");
            person.setBirthYear(1992);
            person.setTc("asdasdasd");
            return new ResponseEntity<>(person, HttpStatus.OK);
        } else {
            person.setName("Gizem");
            person.setSurname("Kısa");
            person.setBirthYear(1992);
            person.setTc("zxczxcasd");
            return new ResponseEntity<>(person, HttpStatus.OK);
        }
    }



}
