import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;


class Actor {

    private String ID, PWD;
    String Name;
    int HP;
    char Gender;
    MonsterBase myBaby;

    Actor() {

    }

    Actor(String gID, String gPWD) {
        ID = gID;
        PWD = gPWD;

    }

}

abstract class MonsterBase {
    String ID, Name;
    int HP;
    int Attack;
    int Defense;
    int type;
    int isDefense = 0;

    MonsterBase() {

        HP = 200;
        Attack = 20;
        Defense = 10;
        type = 0;
    }

    abstract void Attack(MonsterBase first, MonsterBase second);

    abstract void Defense(MonsterBase babymy);
}

class Monster extends MonsterBase {
    Monster() {
        Name = "喵喵";
        ID = "001";
        HP = 100;
        Attack = 25;
        Defense = 20;
        type = 1;
    }

    void Attack(MonsterBase first, MonsterBase second) {
        if (second.Defense < first.Attack) {
            first.HP = first.HP - (second.Attack - first.Defense);
            System.out.println("攻擊系統: " + second.Name + "攻擊成功，" + first.Name + "扣血(攻擊力)");
        } else if (second.Defense < first.Attack) {
            System.out.println("攻擊系統: " + second.Name + "攻擊無效");
        }
    }

    void Defense(MonsterBase babymy) {

        babymy.Defense = babymy.Defense * 1 + babymy.Defense / 4;
        babymy.isDefense = 1;
        System.out.println("防守系統: " + babymy.Name + "進行防守，防守力變成1.25倍");

    }

}

class Monsterfire extends Monster {
    Monsterfire() {
        Name = "小火龍";
        ID = "002";
        HP = 100;
        Attack = 30;
        Defense = 20;
        type = 2;
    }

    void Attack(MonsterBase first, MonsterBase second) {

        int x, n;
        x = (int) (Math.random() * 10) + 1;
        n = (int) (Math.random() * 10) + 1;
        if (isDefense == 0) {
            if (x <= 4) {
                first.HP = first.HP - second.Attack;
                System.out.println("攻擊系統: " + second.Name + "攻擊成功，" + first.Name + "受到攻擊(攻擊力*1)(40%)");
            } else if (x >= 4 && x <= 8) {
                if (n <= 5) {
                    first.HP = first.HP - second.Attack / 2;
                    System.out.println("攻擊系統: " + second.Name + "攻擊成功，" + first.Name + "受到攻擊(攻擊力0.5)(40%*50%)");

                } else if (n > 5) {
                    first.HP = first.HP - second.Attack;
                    System.out.println("攻擊系統: " + second.Name + "攻擊成功，" + first.Name + "受到攻擊(攻擊力*1)(40%*50%)");

                }
            } else if (x > 8) {
                first.HP = first.HP - 0;
                System.out.println("攻擊系統: " + second.Name + "攻擊miss，" + first.Name + "沒有受到傷害(20%)");
            }

        } else if (isDefense == 1) {
            System.out.println("對方有防守!，提升了火系寶貝的攻擊難度");
            if (x <= 4) {
                first.HP = first.HP - second.Attack;
                System.out.println("攻擊系統: " + second.Name + "攻擊成功，" + first.Name + "受到攻擊(攻擊力*1)(40%)");
            } else if (x >= 4 && x <= 8) {
                if (n <= 5) {
                    first.HP = first.HP - second.Attack / 2;
                    System.out.println("攻擊系統: " + second.Name + "攻擊成功，" + first.Name + "受到攻擊(攻擊力0.5)(40%*50%)");

                } else if (n > 5) {
                    first.HP = first.HP - second.Attack;
                    System.out.println("攻擊系統: " + second.Name + "攻擊成功，" + first.Name + "受到攻擊(攻擊力*1)(40%*50%)");

                }
            } else if (x > 8) {
                first.HP = first.HP - 0;
                System.out.println("攻擊系統: " + second.Name + "攻擊miss，" + first.Name + "沒有受到傷害(20%)");
            }
        }

    }

    void Defense(MonsterBase babymy) {
        super.Defense(babymy);

    }
}

class MonsterElect extends Monster {
    MonsterElect() {
        Name = "皮卡丘";
        ID = "003";
        HP = 100;
        type = 3;
        Attack = 25;
        Defense = 20;
    }

    void Attack(MonsterBase first, MonsterBase second) {
        super.Attack(first, second);

    }

    void Defense(MonsterBase babymy) {

        babymy.isDefense = 1;
        babymy.Defense = babymy.Defense * 1 + babymy.Defense / 2;
        System.out.println("防守系統: " + Name + "進行防守，防守力變成1.5倍");
    }

}

class LvUP_Monster extends Monster {
    LvUP_Monster() {
        Name = "喵老大";
        ID = "004";
        HP = super.HP * 2;
        type = 1;
        Attack = super.Attack * 2;
        Defense = super.Defense * 2;
    }

    void Attack(MonsterBase first, MonsterBase second) {
        super.Attack(first, second);
    }

    void Defense(MonsterBase babymy) {
        super.Defense(babymy);
    }
}

class LvUP_Monsterfire extends Monsterfire {
    LvUP_Monsterfire() {
        Name = "火火龍";
        ID = "005";
        HP = super.HP * 2;
        type = 2;
        Attack = super.Attack * 2;
        Defense = super.Defense * 2;
    }

    void Attack(MonsterBase first, MonsterBase second) {
        super.Attack(first, second);
    }

    void Defense(MonsterBase babymy) {
        super.Defense(babymy);
    }
}

class LvUP_MonsterElect extends MonsterElect {
    LvUP_MonsterElect() {
        Name = "雷丘";
        ID = "006";
        HP = super.HP * 2;
        type = 3;
        Attack = super.Attack * 2;
        Defense = super.Defense * 2;
    }

    void Attack(MonsterBase first, MonsterBase second) {
        super.Attack(first, second);
    }

    void Defense(MonsterBase babymy) {
        super.Defense(babymy);
    }
}


class log {

    String name1,name2;
    String mybabyName1,mybabyName2;
    String id1,id2;
    int type1 = 0,type2=0;
    int hp1 = 0,hp2=0;
    int attack1 = 0,attack2=0;
    int defense1 = 0,defense2=0;

    log(String gName1, String gmybabyName1, String gID1, int gType1, int gHP1, int gattack1, int gdefense1
    ,String gName2, String gmybabyName2, String gID2, int gType2, int gHP2, int gattack2, int gdefense2) {
        gName1 = name1;
        gmybabyName1 = mybabyName1;
        gID1 = id1;
        gType1 = type1;
        gHP1 = hp1;
        gattack1 = attack1;
        gdefense1 = defense1;
        gName2 = name2;
        gmybabyName2 = mybabyName2;
        gID2 = id2;
        gType2 = type2;
        gHP2 = hp2;
        gattack2= attack2;
        gdefense2 = defense2;
    }
}

public class Monstergo {

    public static void main(String[] args) {

        String P1Sel, P2Sel;
        String P1createSel, P2createSel;
        String P1LvUP, P2LvUP;
        List<Integer> integersList = new ArrayList<>();
        Scanner P1Scan = new Scanner(System.in);
        Scanner P1create = new Scanner(System.in);
        Scanner P2Scan = new Scanner(System.in);
        Scanner P2create = new Scanner(System.in);

        Actor P1 = new Actor("1", "1");
        System.out.println("玩家(一)請輸入你的名子:");
        P1.Name = P1create.nextLine();

        System.out.println(P1.Name + "請選擇一隻怪獸當您的寵物:[1]喵喵(原型怪獸) [2]小火龍(火系怪獸) [3]皮卡丘(雷系怪獸) ");
        P1createSel = P1create.nextLine();
        if (P1createSel.equals("1")) {
            P1.myBaby = new Monster();
        } else if (P1createSel.equals("2")) {
            P1.myBaby = new Monsterfire();
        } else if (P1createSel.equals("3")) {
            P1.myBaby = new MonsterElect();
        }

        System.out.println(P1.Name + "你想要讓" + P1.myBaby.Name + "進化嗎:[1]是 [2]否");
        P1LvUP = P1create.nextLine();
        if (P1LvUP.equals("1")) {
            if (P1.myBaby.type == 1) {
                P1.myBaby = new LvUP_Monster();
            }
            if (P1.myBaby.type == 2) {
                P1.myBaby = new LvUP_Monsterfire();
            }
            if (P1.myBaby.type == 3) {
                P1.myBaby = new LvUP_MonsterElect();
            }
            System.out.println(P1.Name + "選擇了進化!!!，進化成了" + P1.myBaby.Name + "\n");
        } else if (P1LvUP.equals("2")) {
            System.out.println(P1.Name + "沒有選擇了進化!!!\n");
        }
        System.out.println("玩家(一)的玩家與角色建立完畢\n");

        Actor P2 = new Actor("2", "2");
        System.out.println("玩家(二)請輸入你的名子:");
        P2.Name = P2create.nextLine();
        System.out.println(P1.Name + "請選擇一隻怪獸當您的寵物:[1]喵喵(原型怪獸) [2]小火龍(火系怪獸) [3]皮卡丘(雷系怪獸) ");
        P2createSel = P2create.nextLine();

        if (P2createSel.equals("1")) {
            P2.myBaby = new Monster();
        } else if (P2createSel.equals("2")) {
            P2.myBaby = new Monsterfire();
        } else if (P2createSel.equals("3")) {
            P2.myBaby = new MonsterElect();
        }

        System.out.println(P2.Name + "你想要讓" + P2.myBaby.Name + "進化嗎:[1]是 [2]否");
        P2LvUP = P2create.nextLine();

        if (P2LvUP.equals("1")) {

            if (P2.myBaby.type == 1) {
                P2.myBaby = new LvUP_Monster();
            }
            if (P2.myBaby.type == 2) {
                P2.myBaby = new LvUP_Monsterfire();
            }
            if (P2.myBaby.type == 3) {
                P2.myBaby = new LvUP_MonsterElect();
            }
            System.out.println(P2.Name + "選擇了進化!!!進化成了" + P2.myBaby.Name + "\n");
        } else if (P2LvUP.equals("2")) {
            System.out.println(P2.Name + "沒有選擇了進化!!!\n");
        }
        System.out.println("玩家(二)的玩家與角色建立完畢\n");

        System.out.println("各角色寶貝建立完畢，遊戲開始!\n");

        while (true) {
            System.out.println("新的回合開始了!!");
            System.out.println("-----------------------------------------------------");
            /* 防禦重製 */
            if (P1.myBaby.ID.equals("001") || P1.myBaby.ID.equals("002") || P1.myBaby.ID.equals("003")) {
                P1.myBaby.Defense = 20;
                P1.myBaby.isDefense = 0;
            } else if (P1.myBaby.ID.equals("004") || P1.myBaby.ID.equals("005") || P1.myBaby.ID.equals("006")) {
                P1.myBaby.Defense = 40;
                P1.myBaby.isDefense = 0;
            }
            if (P2.myBaby.ID.equals("001") || P2.myBaby.ID.equals("002") || P2.myBaby.ID.equals("003")) {
                P2.myBaby.Defense = 20;
                P2.myBaby.isDefense = 0;
            } else if (P2.myBaby.ID.equals("004") || P2.myBaby.ID.equals("005") || P2.myBaby.ID.equals("006")) {
                P2.myBaby.Defense = 40;
                P2.myBaby.isDefense = 0;
            }
            /* 防禦重製 */
            int r = (int) (Math.random() * 10);//r=誰先攻擊

            System.out.println(P1.Name + "下達命令給" + P1.myBaby.Name + "\n請選擇: [1]攻擊 [2]防禦 [3]查詢雙方怪獸資料 [4]離開  [5]存檔 [6]載入");

            P1Sel = P1Scan.nextLine();
            System.out.println(P2.Name + "下達命令給" + P2.myBaby.Name + "\n請選擇: [1]攻擊 [2]防禦 [3]查詢雙方怪獸資料 [4]離開  [5]存檔 [6]載入");
            P2Sel = P2Scan.nextLine();

            if (P1Sel.equals("4") || P2Sel.equals("4")) {
                System.out.println("提早結束遊戲，離開!");
                break;
            } else if (P1Sel.equals("3") || P2Sel.equals("3")) {
                System.out.println("查詢雙方怪獸資料");
                System.out.println("玩家(一)為" + P1.Name + "，他的怪獸為" + P1.myBaby.Name);
                System.out.println(P1.myBaby.Name + "編碼(ID):" + P1.myBaby.ID + "\t屬性(type):" + P1.myBaby.type
                        + "\t血量(HP):" + P1.myBaby.HP + "\t攻擊力(Attack):" + P1.myBaby.Attack + "\t防禦力(Defense):"
                        + P1.myBaby.Defense);
                System.out.println("\n玩家(二)為" + P2.Name + "，他的怪獸為" + P2.myBaby.Name);
                System.out.println(P2.myBaby.Name + "編碼(ID):" + P2.myBaby.ID + "\t屬性(type):" + P2.myBaby.type
                        + "\t血量(HP):" + P2.myBaby.HP + "\t攻擊力(Attack):" + P2.myBaby.Attack + "\t防禦力(Defense):"
                        + P2.myBaby.Defense);

            }else if (P1Sel.equals("5") || P2Sel.equals("5")) {
                try {
                    FileWriter freader = new FileWriter("Profile.txt", false);
                    BufferedWriter breader = new BufferedWriter(freader);
                    breader.write(P1.Name + "," + P1.myBaby.Name + "," + P1.myBaby.ID + "," + P2.myBaby.type + ","
                            + P1.myBaby.HP + ","
                            + P1.myBaby.Attack + "," + P1.myBaby.Defense + ",");

                    breader.write(P2.Name + "," + P2.myBaby.Name + "," + P2.myBaby.ID + "," + P2.myBaby.type + ","
                            + P2.myBaby.HP + ","
                            + P2.myBaby.Attack + "," + P2.myBaby.Defense);
                    System.out.println("玩家存檔成功!");

                    breader.flush();
                    freader.close();
                } catch (IOException e) {
                    System.out.println(e.getMessage());
                }

            } else if (P1Sel.equals("6") || P2Sel.equals("6")) {

                ArrayList<log> myLogList;

                try {
                    FileReader freader = new FileReader("Profile.txt");
                    BufferedReader breader = new BufferedReader(freader);
                    String line;
                    myLogList = new ArrayList<log>();
                    if (breader.ready()) {
                        line = breader.readLine();
                        String[] data = line.split(",");
                        myLogList.add(new log(
                                P1.Name = data[0],
                                P1.myBaby.Name = data[1],
                                P1.myBaby.ID = data[2],
                                P1.myBaby.type = Integer.parseInt(data[3]),
                                P1.myBaby.HP = Integer.parseInt(data[4]),
                                P1.myBaby.Attack = Integer.parseInt(data[5]),
                                P1.myBaby.Defense = Integer.parseInt(data[6]),
                                P2.Name = data[7],
                                P2.myBaby.Name = data[8],
                                P2.myBaby.ID = data[9],
                                P2.myBaby.type = Integer.parseInt(data[10]),
                                P2.myBaby.HP = Integer.parseInt(data[11]),
                                P2.myBaby.Attack = Integer.parseInt(data[12]),
                                P2.myBaby.Defense = Integer.parseInt(data[13])));
                       
                        System.out.println("已從" + "Profile.txt" + "載入遊戲!");

                    }
                    freader.close();
                } catch (IOException e) {
                    System.out.println(e.getMessage());
                }

            }  
            
            else {
                if (P2Sel.equals("2")) {
                    System.out.println(P2.Name + "選擇了防守");
                    P2.myBaby.Defense(P2.myBaby);

                }
                if (P1Sel.equals("2")) {
                    System.out.println(P1.myBaby.Name + "進行防守");
                    P1.myBaby.Defense(P1.myBaby);
                }

                if (r < 5) {
                    System.out.println("本回合" + P1.Name + "方優先攻擊!");
                    if (P1Sel.equals("1")) {
                        System.out.println(P1.myBaby.Name + "攻擊了!");

                        (P1.myBaby).Attack(P2.myBaby, P1.myBaby);

                        if (P2.myBaby.HP <= 0) {
                            System.out.println("回合結束，顯示雙方血量");
                            System.out
                                    .println(P1.Name + "的" + P1.myBaby.Name + "血量:" + P1.myBaby.HP + "，" + P2.Name
                                            + "的"
                                            + P2.myBaby.Name + "血量:" + P2.myBaby.HP);
                            System.out.println(P1.Name + " WIN!!!!!~~~~");
                            break;
                        }
                    }

                    if (P2Sel.equals("2")) {

                    } else if (P2Sel.equals("1")) {
                        System.out.println("輪到" + P2.myBaby.Name + "攻擊了!");

                        P2.myBaby.Attack(P1.myBaby, P2.myBaby);
                    }

                    if (P1.myBaby.HP <= 0) {
                        System.out.println("回合結束，顯示雙方血量");
                        System.out
                                .println(P1.Name + "的" + P1.myBaby.Name + "血量:" + P1.myBaby.HP + "，" + P2.Name + "的"
                                        + P2.myBaby.Name + "血量:" + P2.myBaby.HP);
                        System.out.println(P1.Name + " WIN!!!!!~~~~");
                        break;
                    }

                } else {
                    System.out.println("本回合" + P2.Name + "優先攻擊!");
                    if (P2Sel.equals("1")) {
                        System.out.println(P2.myBaby.Name + "攻擊了!");

                        P2.myBaby.Attack(P1.myBaby, P2.myBaby);

                        if (P1.myBaby.HP <= 0) {
                            System.out.println("回合結束，顯示雙方血量");
                            System.out
                                    .println(P1.Name + "的" + P1.myBaby.Name + "血量:" + P1.myBaby.HP + "，" + P2.Name
                                            + "的"
                                            + P2.myBaby.Name + "血量:" + P2.myBaby.HP);
                            System.out.println(P2.Name + " WIN!!!!!~~~~");
                            break;
                        }
                    } else if (P2Sel.equals("2")) {

                    }

                    if (P1Sel.equals("2")) {

                    } else if (P1Sel.equals("1")) {
                        System.out.println("輪到" + P1.myBaby.Name + "攻擊了!");

                        P1.myBaby.Attack(P2.myBaby, P1.myBaby);

                    }

                    if (P2.myBaby.HP <= 0) {
                        System.out.println("回合結束，顯示雙方血量");
                        System.out
                                .println(P1.Name + "的" + P1.myBaby.Name + "血量:" + P1.myBaby.HP + "，" + P2.Name + "的"
                                        + P2.myBaby.Name + "血量:" + P2.myBaby.HP);
                        System.out.println(P1.Name + " WIN!!!!!~~~~");
                        break;
                    }

                }
                System.out.println("回合結束，顯示雙方血量");
                System.out.println(P1.Name + "的" + P1.myBaby.Name + "血量:" + P1.myBaby.HP + "，" + P2.Name + "的"
                        + P2.myBaby.Name + "血量:" + P2.myBaby.HP);

            }
        }
        System.out.println("GAME OVER");

    }
}
