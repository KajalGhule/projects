package com.project.customexception;

public class DuplicateFacultyException extends RuntimeException{
  public DuplicateFacultyException(String message) {
	super(message);
}
}
