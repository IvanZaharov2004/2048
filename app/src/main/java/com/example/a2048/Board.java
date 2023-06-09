package com.example.a2048;

import androidx.annotation.NonNull;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

public class Board {
    protected ArrayList<ArrayList<Integer>> map;
    protected Random random = new Random();

    public Board() {
        map = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            map.add(new ArrayList<>(Arrays.asList(0, 0, 0, 0)));
        }
    }

    public Board(String save) {
        Scanner in = new Scanner(save);
        ArrayList<ArrayList<Integer>> temp = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            temp.add(new ArrayList<>());
            for (int j = 0; j < 4; j++) {
                temp.get(i).add(in.nextInt());
            }
        }
        map = temp;
    }

    // добавляем новую плитку
    public void add_tile() {
        boolean is_full = true;
        for (int i = 0; i < 4; i++) {
            if (map.get(i).contains(0)) {
                is_full = false;
                break;
            }
        }
        if (!is_full) {
            int x = random.nextInt(4);
            int y = random.nextInt(4);
            int n = random.nextInt(10);
            if (n == 9)
                n = 4;
            else
                n = 2;
            while (map.get(x).get(y) != 0) {
                x = random.nextInt(4);
                y = random.nextInt(4);
            }
            map.get(x).set(y, n);
        }
    }

    // обратный порядок чисел
    public void reverse() {
        for (int i = 0; i < 4; i++) {
            Collections.reverse(map.get(i));
        }
    }

    // транспонирование
    public void transpose() {
        ArrayList<ArrayList<Integer>> temp = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            temp.add(new ArrayList<>());
            for (int j = 0; j < 4; j++) {
                temp.get(i).add(map.get(j).get(i));
            }
        }
        map = temp;
    }

    // "спускаем" нули
    public void cover_up() {
        ArrayList<ArrayList<Integer>> temp = new ArrayList<>();
        int count;
        int item;
        for (int i = 0; i < 4; i++) {
            temp.add(new ArrayList<>(Arrays.asList(0, 0, 0, 0)));
        }
        for (int i = 0; i < 4; i++) {
            count = 0;
            for (int j = 0; j < 4; j++) {
                item = map.get(i).get(j);
                if (item != 0) {
                    temp.get(i).set(count, item);
                    count++;
                }
            }
        }
        map = temp;
    }

    // сложение плиток
    public int merge(int score) {
        int item;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 3; j++) {
                item = map.get(i).get(j);
                if (map.get(i).get(j + 1) == item & item != 0) {
                    map.get(i).set(j, item * 2);
                    map.get(i).set(j + 1, 0);
                    score += item * 2;
                }
            }
        }
        return score;
    }


    @NonNull
    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < 4; i++) {
            s.append(map.get(i).toString()).append("\n");
        }
        return s.toString();
    }
    public String toSaveString(){
        StringBuilder out = new StringBuilder();
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                out.append(map.get(i).get(j)).append(" ");
            }
        }
        return out.toString();
    }
}