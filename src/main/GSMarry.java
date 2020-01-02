package main;

import java.util.Arrays;

public class GSMarry {
    /**
     * FunctionName:getIndex
     * Description: 查找person2在person1的prefer排序
     *
     * @param person1 被查找的人
     * @param person2 需要查找的人
     * @return prefer序号 0-2 找到的序号 -1 找不到
     */
    public static int getIndex(Person person1, Person person2) {
        for (int i = 0; i < 3; i++) {
            if (person2 == person1.prefer[i]) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Person[] man = new Person[3];
        Person[] woman = new Person[3];
        char[] manName = {'X', 'Y', 'Z'};
        char[] womanName = {'A', 'B', 'C'};
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
        //当还有男人没有匹配则继续循环
        while (!(man[0].isMatch == true && man[1].isMatch == true && man[2].isMatch == true)) {
            //3个男人依次求婚
            for (int m = 0; m < 3; m++) {
                //如果当前男人未匹配
                if (man[m].isMatch == false) {
                    //按照他的喜好顺序求婚
                    for (int p = 0; p < 3; p++) {
                        //womanP为当前被求婚女性
                        Person womanP;
                        womanP = man[m].prefer[p];
                        //如果当前被求婚女性 （未匹配/比起自己partner更喜欢求婚男子）
                        if (womanP.isMatch == false || (getIndex(womanP, womanP.partner) > getIndex(womanP, man[m]))) {
                            man[m].setMatch(true);
                            man[m].setPartner(womanP);
                            womanP.setMatch(true);
                            womanP.setPartner(man[m]);
                            break;
                        }
                    }
                }
            }
        }
        for (int i = 0;i < 3;i++){
            System.out.println(man[i].name+"-"+man[i].partner.name);
        }
    }
}

class Person {
    char name;
    boolean isMatch;
    Person partner;
    Person[] prefer;

    public Person() {
        this.isMatch = false;
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

    public boolean isMatch() {
        return isMatch;
    }

    public void setMatch(boolean match) {
        isMatch = match;
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
        this.prefer = Arrays.copyOf(prefer, 3);
    }
}
