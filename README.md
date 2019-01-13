# A Java Programming Warm-Up

This assignment is intended to warm up your Java programming skills. 
In this assignment, you will write three programs that simply process input provided on the "standard input" and print results on the "standard output". These programs will not require the use of object-oriented programming and for the most part can be written as a single main method with one or maybe two helper functions if any. The purpose of this assignment is to exercise basic programming constructs that you should already be familiar with like loops, if/then statements, basic data types and arrays.

The assignment is specified in three parts that are in increasing level of difficulty called A1Novice, A1Adept, and A1Jedi. In all three parts, the starter code provides a class with a main method that creates an input Scanner object set up to read input from the standard input (i.e., console).

You are responsible, in each case, for adding code to read input from the console in a specific format, and to use those inputs to calculate and produce output to the console using ```System.out```.

You mustmatch the format of the example outputs provided and should not produce any additional output of any kind. In particular, you should not print any input prompts or debugging statements.

You are free to (and in fact encouraged to) create additional static class methods to use as helper functions as you see fit (although each part can be done relatively easily without having to create any additional methods).

Scanner

This assignment requires you to make use of a Scanner object. You can read the documentation for Scanner here: http://docs.oracle.com/javase/11/docs/api/java/util/Scanner.html

A Scanner object is associated with a source of input. In our case, this will be keyboard input from the console. By default, a Scanner object will parse input as whitespace-separated tokens and provides methods for parsing the next available token as a particular type.

For example, the method next() will retrieve the next token (i.e., word) as a String. Similarly, the method nextInt() interprets the next token as an integer while nextDouble() will interpret the next token as a double value. For this assignment, you shouldn't have to use any Scanner methods other than next(), nextInt(), and nextDouble(). In particular, you should avoid using nextLine(). Do not assume that the input is organized into lines. All of the input could be on a single line or each word might be on a different line or something in between. Do not make any assumptions about the input being organized into lines. 

For this assignment, you can assume that the input will always be valid and conform to the description below. In other words, you do not have to worry about validating the input or being able to deal with unexpected input.

A1Novice

This program will read in data that represents shopping orders from a number of customers and report the total amount spent on a per customer basis. The input provided will have the following form:
* The first input will be an integer indicating the total number of customers.
* Then, for each customer, the input will be comprised of:
  * The first name of the customer
  * The last name of the customer
  * The number or items bought.
  * For each item bought, the input will be contain:
    * An integer quantity of the item bought
    * The name of the item
    * The price of the item as a double


For each customer, your program should print one line of ouptut in the following form:

F. Last_Name Total

Where "F." represents the first letter initial of the first name of the customer, Last_Name represents the last name of the customer, and Total is the total cost of the items purchased.

