package com.example.project2.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.project2.model.project2;
import com.example.project2.repository.project2Repository;


@RestController
@RequestMapping("/api")
public class project2Controller {

    @Autowired
    project2Repository project2Repository;


    //to display specific row in the tabel using id
    @GetMapping("/show/{id}")
    public ResponseEntity<project2> geproject2ById(@PathVariable Long id){
        Optional<project2> project2 = project2Repository.findById(id);

        if (project2.isPresent()) {
      return new ResponseEntity<>(project2.get(), HttpStatus.OK);
    } 
    else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    }

    //to delete row by using id
    @DeleteMapping("delete/{id}")
    public ResponseEntity<HttpStatus> delete_by_id(@PathVariable("id") long id){
        project2Repository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
