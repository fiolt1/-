package day6;

import java.util.Scanner;

/**
 * 真人玩家类
 * 属性: name  score
 * 方法:出拳方法
 */
public class PersonalPlayer {
    // 属性
    private String name; // 姓名
    private int score;  // 分数

    public PersonalPlayer() {
        System.out.println("------无参构造器-----");
    }

    public PersonalPlayer(String name, int score) {
        this.name = name;
        if (score >= 0) {
            this.score = score;
        }
        System.out.println("--------有参构造器------");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        // 分数不能为负
        if (score >= 0) {
            this.score = score;
        }
    }
    // toString方法  以字符串形式打印出对象

    @Override
    public String toString() {
        return "PersonalPlayer{" +
                "name='" + name + '\'' +
                ", score=" + score +
                '}';
    }


    // 出拳方法
    public int showFist() {
        System.out.println("请出拳(序号):1.石头  2.剪刀  3.布");
        Scanner in = new Scanner(System.in);
        int personalFistType = in.nextInt();
        switch (personalFistType) {
            case 1:
                System.out.println(this.name + "真人玩家出拳:石头");
                break;
            case 2:
                System.out.println(this.name + "真人玩家出拳:剪刀");
                break;
            case 3:
                System.out.println(this.name + "真人玩家出拳:布");
                break;
        }
        return personalFistType;
    }
}
