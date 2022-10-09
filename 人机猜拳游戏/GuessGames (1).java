package day6;

import java.util.Scanner;

/**
 * 游戏类
 * 属性: 真人玩家类（姓名 分数） 电脑玩家类（姓名 分数） 对战次数
 * 方法：1.界面初始化   2.开始游戏  3.人机对战  4.统计结果
 */
class GuessGames {
    // 属性
    private PersonalPlayer personalPlayer;
    private ComputerPlayer computerPlayer;
    // 次数
    private int count;

    //1.初始化方法
    public void init() {
        System.out.println("*********欢迎进入游戏世界*********");
        System.out.println("*******猜拳游戏规则:1.石头  2.剪刀  3.布********");
        System.out.println("请输入要对战的英雄:1.刘备  2.曹操  3.孙权");
        // 创建电脑玩家对象
        computerPlayer = new ComputerPlayer();
        int choice = new Scanner(System.in).nextInt();
        switch (choice) {
            case 1:
                //设置name值
                computerPlayer.setName("刘备");
                break;
            case 2:
                //设置name值
                computerPlayer.setName("曹操");
                break;
            case 3:
                //设置name值
                computerPlayer.setName("孙权");
                break;
        }
        System.out.println("请输入你的名字:");
        String name = new Scanner(System.in).next();
        //创建真人玩家对象
        personalPlayer = new PersonalPlayer();
        personalPlayer.setName(name);
        System.out.println(personalPlayer.getName() + " VS " + computerPlayer.getName() + "对战");
    }

    // 2.开始游戏
    public void start() {
        // 1.调用初始化方法
        this.init();
        String isAgain = null;
        do {
            System.out.println("是否要开始游戏(y/n):");
            String isBegin = new Scanner(System.in).next();
            if ("y".equalsIgnoreCase(isBegin)) {
                // 调用真人玩家出拳方法
                int personalFistType = personalPlayer.showFist();
                // 调用电脑玩家出拳方法
                int computerFistType = computerPlayer.showFist();
                // 3.人机对战
                this.calcScore(personalFistType, computerFistType);
                // 次数加1
                this.count++;
                System.out.println("-----是否要进行下一轮游戏(y/n):------");
                isAgain = new Scanner(System.in).next();
                if ("n".equalsIgnoreCase(isAgain)) {
                    // 统计结果
                    this.result();
                }
            }
        } while ("y".equalsIgnoreCase(isAgain));
    }

    // 4.统计结果
    private void result() {
        System.out.println("------------------------");
        System.out.println(personalPlayer.getName() + " VS " + computerPlayer.getName() + "对战");
        System.out.println("对战次数:" + this.count);
        System.out.println("姓名 \t 分数");
        System.out.println(personalPlayer.getName() + " \t " + personalPlayer.getScore());
        System.out.println(computerPlayer.getName() + " \t " + computerPlayer.getScore());
        //判断分数输赢
        if (personalPlayer.getScore() > computerPlayer.getScore()) {
            System.out.println("恭喜你,赢了!");
        } else if (personalPlayer.getScore() < computerPlayer.getScore()) {
            System.out.println("真遗憾你输了,请下次再战!");
        } else {
            System.out.println("友谊第一!");
        }
    }

    // 3.人机对战
    public void calcScore(int personalFistType, int computerFistType) {
        // 判断输赢
        if (personalFistType == computerFistType) {
            System.out.println("平局!");
        } else if ((personalFistType == 1 && computerFistType == 2)
                || (personalFistType == 2 && computerFistType == 3)
                || (personalFistType == 3 && computerFistType == 1)) {
            System.out.println(personalPlayer.getName() + " 真人玩家赢了");
            //分数加1
            personalPlayer.setScore(personalPlayer.getScore() + 1);
        } else {
            System.out.println(computerPlayer.getName() + " 电脑玩家赢了");
            //分数加1
            computerPlayer.setScore(computerPlayer.getScore() + 1);
        }
    }
}
