/**
 * じゃんけん出し手 列挙型
 *
 */
public enum RPSType {
  ROCK("グー",1),      // グー
  SCISSORS("チョキ",2),  // チョキ
  PAPER("パー",3);     // パー

  private final String name;
  private final int id;

  /**
   * コンストラクタ
   * @param id ID
   */
  private RPSType(String name, final int id) {
    this.name = name;
    this.id = id;
  }

  /*
   * 列挙型のID取得
   * @return ID
   */
  public int getId() {
    return id;
  }

  /*
   * 列挙型のString取得
   * @return String
   */
  public String getName() {
    return name;
  }
}
