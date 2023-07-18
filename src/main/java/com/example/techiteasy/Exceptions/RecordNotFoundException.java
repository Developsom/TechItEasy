package com.example.techiteasy.Exceptions;


public class RecordNotFoundException extends RuntimeException {

        public RecordNotFoundException(){

        }

        public RecordNotFoundException(String message) {
            super(message);
        }
}
