import java.util.Random;
import java.util.Scanner;

public class RPSGame {

  public static void main(String[] args) {

//    int id = RPSType.PAPER.getId();
//    System.out.println(id);

    //文言
    //開始文言
    String RPSgame = "-----じゃんけんゲームを開始します。以下から実施したいじゃんけんモードを選択してください-----"
        + "\r\nマニュアルじゃんけん：m"
        + "\r\nオートじゃんけん：a"
        + "\r\n対戦をやめる：e";

    //じゃんけんゲーム開始
    System.out.println(RPSgame);

    boolean handSelecct = true;

    while (handSelecct)
    {
      String hands = selectType();
      if(hands.equals("m"))
      {
        manual();
      }
      else if(hands.equals("a"))
      {
        auto();
      }
      else if (hands.equals("e"))
      {
        System.out.println("じゃんけんゲームを終了します。");
        handSelecct = false;
      }
      else
      {
        System.out.println("再度、m,a,eを選択");
      }
    }

  }


  /**
   * ユーザーからの入力受付
  */
  private static String selectType() {

    Scanner scan = new Scanner(System.in);
    String input = scan.next();

    return input;
  }

  /**
   * マニュアルじゃんけん
   * @param handsSelect
  */
  private static void manual() {

    System.out.println("入力して対戦を行います。対戦をやめたい場合、eを選択。");
    System.out.println("1：グー。2：チョキ。3：パー。e：対戦終了");

    RPSPlayerBase player = new RPSPlayer();

    boolean manualHandSelecct = true;

    while (manualHandSelecct)
    {
      String hands = selectType();
      Random ran = new Random();

      if(hands.equals("1")|| hands.equals("2") || hands.equals("3") )
      {

        int intHands = Integer.parseInt(hands);
        RPSType userHand = player.go(intHands);

        int cpuRandom = ran.nextInt(3) + 1;
        RPSType cpuHand = player.go(cpuRandom);

        //出し手
        System.out.println("あなたの出し手は" + userHand.getName() + "です。");
        System.out.println("CPUの出し手は" + cpuHand.getName() + "です。");

        if((userHand.getId()==1 && cpuHand.getId()==2)
            || (userHand.getId()==2 && cpuHand.getId()==3)
            || (userHand.getId()==3 && cpuHand.getId()==1))
        {
          System.out.println("あなたの勝利です。");
          System.out.println("");
          System.out.println("再度マニュアルじゃんけんできます。");
          System.out.println("1：グー。2：チョキ。3：パー。e：対戦終了");
        }
        else if((cpuHand.getId()==1 && userHand.getId()==2)
            || (cpuHand.getId()==2 && userHand.getId()==3)
            || (cpuHand.getId()==3 && userHand.getId()==1))
        {
          System.out.println("CPUの勝利です。");
          System.out.println("");
          System.out.println("再度マニュアルじゃんけんできます。");
          System.out.println("1：グー。2：チョキ。3：パー。e：対戦終了");
        }
        else
        {
          System.out.println("あいこです。あいこで・・・");
          System.out.println("");
          System.out.println("1：グー。2：チョキ。3：パー。e：対戦終了");
        }

      }
      else if (hands.equals("e"))
      {
        System.out.println("マニュアルじゃんけんを終了します。");
        System.out.println("");
        System.out.println("再度、じゃんけんモードを選択できます。"
            + "\r\nマニュアルじゃんけん：m"
            + "\r\nオートじゃんけん：a"
            + "\r\n対戦をやめる：e");
        manualHandSelecct = false;
      }
      else
      {
        System.out.println("再度、1,2,3,eを選択");
      }
    }

  }

  /**
   * オートじゃんけん
  */
  private static void auto() {

    System.out.println("観戦をします。");

    RPSPlayerBase player = new RPSPlayer();

    boolean autoHandSelecct = true;
    int winCpu1 = 0;
    int winCpu2 = 0;
    int draw = 0;
    Random ran = new Random();

    while(autoHandSelecct)
    {

      while ((winCpu1 + winCpu2) < 51) {
        // CPU1の出し手
        int cpu1Random = ran.nextInt(3) + 1;
        RPSType cpu1Hand = player.go(cpu1Random);

        // CPU2の出し手
        int cpu2Random = ran.nextInt(3) + 1;
        RPSType cpu2Hand = player.go(cpu2Random);

        // 出し手
        System.out.println("CPU1の出し手は" + cpu1Hand.getName() + "です。");
        System.out.println("CPU2の出し手は" + cpu2Hand.getName() + "です。");

        if ((cpu1Hand.getId() == 1 && cpu2Hand.getId() == 2)
            || (cpu1Hand.getId() == 2 && cpu2Hand.getId() == 3)
            || (cpu1Hand.getId() == 3 && cpu2Hand.getId() == 1)) {
          System.out.println("CPU1の勝利です。");
          System.out.println("");

          winCpu1++;

        } else if ((cpu2Hand.getId() == 1 && cpu1Hand.getId() == 2)
            || (cpu2Hand.getId() == 2 && cpu1Hand.getId() == 3)
            || (cpu2Hand.getId() == 3 && cpu1Hand.getId() == 1)) {
          System.out.println("CPU2の勝利です。");
          System.out.println("");

          winCpu2++;
        } else {
          System.out.println("あいこです。あいこで・・・");

          draw++;
        }
      }

      if (winCpu2 < winCpu1) {
        System.out.println("======================================");
        System.out.println("CPU1の勝利です。");
        System.out.println("じゃんけん回数（あいこ含む）：" + (winCpu1 + winCpu2 + draw));
        System.out.println("CPU1勝ち数：" + winCpu1);
        System.out.println("CPU1負け数：" + (50 - winCpu1));
        System.out.println("CPU2勝ち数：" + winCpu2);
        System.out.println("CPU2負け数：" + (50 - winCpu2));
        System.out.println("CPU1がCPU2より" + (winCpu1 - winCpu2) + "回多く勝っています。");
        System.out.println("======================================");
        autoHandSelecct = autoGameSelect(autoHandSelecct);
      } else if (winCpu1 < winCpu2) {
        System.out.println("======================================");
        System.out.println("CPU2の勝利です。");
        System.out.println("じゃんけん回数（あいこ含む）：" + (winCpu1 + winCpu2 + draw));
        System.out.println("CPU2勝ち数：" + winCpu2);
        System.out.println("CPU2負け数：" + (50 - winCpu2));
        System.out.println("CPU1勝ち数：" + winCpu1);
        System.out.println("CPU1負け数：" + (50 - winCpu1));
        System.out.println("CPU2がCPU1より" + (winCpu2 - winCpu1) + "回多く勝っています。");
        System.out.println("======================================");
        autoHandSelecct = autoGameSelect(autoHandSelecct);
      } else if (winCpu1 == winCpu2) {
        System.out.println("======================================");
        System.out.println("引き分けです。");
        System.out.println("じゃんけん回数（あいこ含む）：" + (winCpu1 + winCpu2 + draw));
        System.out.println("======================================");
        autoHandSelecct = autoGameSelect(autoHandSelecct);
      }
    }
  }


  private static boolean autoGameSelect(boolean autoHandSelecct) {

    System.out.println("もう一度観戦する：c じゃんけんモードに戻る：e");
    String continueAuto = selectType();
    if(continueAuto.equals("c"))
    {
      autoHandSelecct = true;
    }
    else if(continueAuto.equals("e"))
    {
      autoHandSelecct = false;
      System.out.println("オートじゃんけんを終了します。");
      System.out.println("");
      System.out.println("再度、じゃんけんモードを選択できます。"
          + "\r\nマニュアルじゃんけん：m"
          + "\r\nオートじゃんけん：a"
          + "\r\n対戦をやめる：e");
    }
    else
    {
      System.out.println("以下文字を入力してください。");
      autoGameSelect(autoHandSelecct);
    }
    return autoHandSelecct;

  }

}
