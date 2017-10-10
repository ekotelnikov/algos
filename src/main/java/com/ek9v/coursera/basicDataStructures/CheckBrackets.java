package com.ek9v.coursera.basicDataStructures;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Stack;

class Bracket {
    Bracket(char type, int position) {
        this.type = type;
        this.position = position;
    }

    boolean isMatch(char c) {
        if (this.type == '[' && c == ']')
            return true;
        if (this.type == '{' && c == '}')
            return true;
        if (this.type == '(' && c == ')')
            return true;
        return false;
    }

    char type;
    int position;
}

class CheckBrackets {
    public static void main(String[] args) throws IOException {
        InputStreamReader input_stream = new InputStreamReader(System.in);
        BufferedReader reader = new BufferedReader(input_stream);
        String text = reader.readLine();

        int answer = checkBrackets(text);
        System.out.println(answer == 0 ? "Success" : String.valueOf(answer));
    }

    static int checkBrackets(String text) {
        Stack<Bracket> openingBrackets = new Stack<>();
        for (int position = 0; position < text.length(); ++position) {
            char next = text.charAt(position);

            if (next == '(' || next == '[' || next == '{') {
                Bracket b = new Bracket(next, position);
                openingBrackets.push(b);
            }

            if (next == ')' || next == ']' || next == '}') {
                if (openingBrackets.isEmpty()) {
                    return position+1;
                }
                Bracket b = openingBrackets.pop();
                if (!b.isMatch(next)) {
                    return position+1;
                }
            }
        }

        Bracket openBracket = null;
        while (!openingBrackets.isEmpty()) {
            openBracket = openingBrackets.pop();
        }
        if (openBracket != null) {
            return openBracket.position + 1;
        }

        return 0;
    }
}
