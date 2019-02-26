package com.rest.practice.util;

@FunctionalInterface
interface CalculatePrice<T> {
    double calculate(double price);
}
