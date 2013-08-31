package com.beepscore.LongFromString;

public class NumberTooBigException extends Exception 
{
    NumberTooBigException (String message)
    {
        super (message);
    }
}
