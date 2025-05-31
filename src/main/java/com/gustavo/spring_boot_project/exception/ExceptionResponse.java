package com.gustavo.spring_boot_project.exception;

import java.util.Date;

public record ExceptionResponse(Date timestamp, String message, String details) {

}
