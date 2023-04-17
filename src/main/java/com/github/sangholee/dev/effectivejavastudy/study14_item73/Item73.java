package com.github.sangholee.dev.effectivejavastudy.study14_item73;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.AbstractSequentialList;
import java.util.LinkedList;
import org.springframework.core.NestedRuntimeException;
import org.springframework.core.io.FileSystemResource;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataAccessResourceFailureException;
import org.springframework.dao.DataIntegrityViolationException;

public class Item73 {

    public static void main(String[] args) {
        AbstractSequentialList<String> sequentialList = new LinkedList<>();

        // 예외 번역
//        NestedRuntimeException exception = new DataIntegrityViolationException();

//        DataAccessException dataAccessException = new DataAccessResourceFailureException();

        // 저 수준의 예외
        IOException ioException = new IOException();
//        FileSystemResource fileSystemResource = new FileSystemResource();
//        fileSystemResource.getInputStream();
        // 고수준의 예외
        FileNotFoundException fileNotFoundException = new FileNotFoundException();
    }

}
