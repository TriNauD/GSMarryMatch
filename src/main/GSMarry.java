package main;

import java.util.Arrays;

public class GSMarry {
    public static void main(String[] args) {
        Person[] man = new Person[3];
        Person[] woman = new Person[3];
        char[] manName = {'X', 'Y', 'Z'};
        char[] womanName = {'A', 'B', 'C'};
        //char[][] manPreferNameList = {{'A','B','C'},{'B','A','C'},{'A','B','C'}};
        //char[][] womanPreferNameList = {{'Y','X','Z'},{'X','Y','Z'},{'X','Y','Z'}};
        //给男人和女人赋予名字
        for (int i = 0; i < 3; i++) {
            man[i] = new Person(manName[i]);
            woman[i] = new Person(womanName[i]);
        }
        //男女的偏好表
        Person[][] manPreferList = {{woman[0], woman[1], woman[2]}, {woman[1], woman[0], woman[2]}, {woman[0], woman[1], woman[2]}};
        Person[][] womanPreferList = {{man[1], man[0], man[2]}, {man[0], man[1], man[2]}, {man[0], man[1], man[2]}};
        //输入男女偏好
        for (int i = 0; i < 3; i++) {
            man[i].setPrefer(manPreferList[i]);
            woman[i].setPrefer(womanPreferList[i]);
        }
    }
}

class Person {
    char name;
    boolean isMarry;
    Person partner;
    Person[] prefer;

    public Person() {
        this.isMarry = false;
    }

    public Person(char name) {
        this.name = name;
    }

    public char getName() {
        return name;
    }

    public void setName(char name) {
        this.name = name;
    }

    public boolean isMarry() {
        return isMarry;
    }

    public void setMarry(boolean marry) {
        isMarry = marry;
    }

    public Person getPartner() {
        return partner;
    }

    public void setPartner(Person partner) {
        this.partner = partner;
    }

    public Person[] getPrefer() {
        return prefer;
    }

    public void setPrefer(Person[] prefer) {
        this.prefer = Arrays.copyOf(prefer,3);
    }
}
