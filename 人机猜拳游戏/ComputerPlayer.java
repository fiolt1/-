package day6;

/**
 * 电脑玩家类
 * 属性: 名字  分数
 * 方法: 出拳方法
 */
public class ComputerPlayer {
    // 属性
    private String name;
    private int score;

    //出拳方法
    public int showFist() {
        //电脑随机出拳
        int computerFistType = (int) (Math.random() * 3 + 1);
        switch (computerFistType) {
            case 1:
                System.out.println(this.name + " 电脑玩家出拳:石头");
                break;
            case 2:
                System.out.println(this.name + " 电脑玩家出拳:剪刀");
                break;
            case 3:
                System.out.println(this.name + " 电脑玩家出拳:布");
                break;
        }
        return computerFistType;
    }

    public ComputerPlayer() {
    }

    public ComputerPlayer(String name, int score) {
        this.name = name;
        if (score >= 0) {
            this.score = score;
        }
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
        if (score >= 0) {
            this.score = score;
        }
    }

    @Override
    public String toString() {
        return "ComputerPlayer{" +
                "name='" + name + '\'' +
                ", score=" + score +
                '}';
    }
}
