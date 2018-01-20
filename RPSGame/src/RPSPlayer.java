  public class RPSPlayer extends RPSPlayerBase {

  @Override
  public RPSType go(int intHands) {

    switch(intHands)
    {
      case 1:
        return RPSType.ROCK;

      case 2:
        return RPSType.SCISSORS;

      case 3:
        return RPSType.PAPER;
    }

    return null;
  }


}
