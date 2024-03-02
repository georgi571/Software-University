package _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._13JavaOOPRetakeExam20December2021._01HighQualityStructure.christmasRaces.io;

import _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._13JavaOOPRetakeExam20December2021._01HighQualityStructure.christmasRaces.io.interfaces.InputReader;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleReader  implements InputReader {
    private BufferedReader reader;

    public ConsoleReader() {
        this.reader = new BufferedReader(new InputStreamReader(System.in));
    }

    @Override
    public String readLine() throws IOException {
        return this.reader.readLine();
    }
}
