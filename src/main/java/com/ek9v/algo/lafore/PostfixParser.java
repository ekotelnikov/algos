package com.ek9v.algo.lafore;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PostfixParser {

    public PostfixParser() {
    }

    public String parse(String expression) {
        List<Character> chars = convertToList(expression);

        //TODO use stacks instead of list, take 2 digits and 1 operator
        List<Character> digits = filterDigits(chars);
        List<Character> operators = filterOperators(chars);
        List<Character> parsed = joinLists(digits, operators);

        Optional<String> parsedExp = convertToString(parsed);

        return parsedExp.get();
    }

    private Optional<String> convertToString(List<Character> parsed) {
        return parsed.stream()
                    .map(Object::toString)
                    .reduce((acc, e) -> acc + e);
    }

    private List<Character> joinLists(List<Character> digits, List<Character> operators) {
        return Stream.concat(digits.stream(), operators.stream())
                    .collect(Collectors.toList());
    }

    private List<Character> filterOperators(List<Character> chars) {
        return chars.stream()
                    .filter(c -> !Character.isDigit(c))
                    .collect(Collectors.toList());
    }

    private List<Character> filterDigits(List<Character> chars) {
        return chars.stream()
                    .filter(Character::isDigit)
                    .collect(Collectors.toList());
    }

    private List<Character> convertToList(String expression) {
        return expression.chars()
                    .mapToObj(c -> (char) c)
                    .collect(Collectors.toList());
    }
}