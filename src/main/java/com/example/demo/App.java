package com.example.demo;

import java.util.Scanner;

public class App {

    private Patterns patterns = new Patterns();

    public void start(){
        System.out.println("\nПривет! Это игра \"Угадай паттерн\"" +
                "\n Тебе будет дан пример паттерна на языке Java (выделен красным цветом)" +
                "\n После этого варианты правильного ответа" +
                "\n Твоя задача угадать правильный паттерн и написать его название в консоль");

        while (true) {
            System.out.println("Начнем? (1 - да / 0 - нет)");
            if (getConsoleMessage() == 1) {
                int pattern;
                pattern = patterns.getPattern(getRandomPatternNumber());
                System.out.println("Какой это паттерн?" +
                        "\n Варианты ответа: " +
                        "\n0 - Adapte" +
                        "\n1 - Bridge" +
                        "\n2 - Composite" +
                        "\n3 - Decorator" +
                        "\n4 - Facade" +
                        "\n5 - Flyweight" +
                        "\n6 - Proxy");
                if(pattern == getConsoleMessage()){
                    System.out.println("Верно!");
                }
                else{
                    System.out.println("Не угадал!");
                }

            } else if (getConsoleMessage() == 0) {
                break;
            } else {
                System.out.println("Введено некорректное значение!");
            }
        }

    }

    private int getConsoleMessage(){
        Scanner in = new Scanner(System.in);
        int message;
        System.out.print("Ответ: ");
        try {
            message = in.nextInt();
        }
        catch (Exception e){
            return -1;
        }
        return message;
    }

    public int getRandomPatternNumber(){
        return (int) (Math.random() * 7);
    }

}
