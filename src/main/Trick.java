package main;
/**
 * 
 */

/**
 * @author bmille
 *
 */
public enum Trick {
	/** R: Rock parameters. */
	R ("Rock", "No winner", "You lose", "You win"),
	/**	 * P: Paper parameters. */
	P ("Paper", "You win", "No winner", "You lose"),
	/** S: Scissors parameters. */
	S ("Scissors", "You lose", "You win", "No winner");
	
	/** name: Name of the trick. */
	private String name = "";
	/** resRock: Result against rock. */
	private String resRock = "";
	/** resPaper: Result against paper. */
	private String resPaper = "";
	/** resScissors: Result against scissors. */
	private String resScissors = "";
	
	/**
	 * Constructor.
	 * @param nameParam Name of the trick
	 * @param resRockParam Result against rock
	 * @param resPaperParam Result against paper
	 * @param resScissorsParam Result against scissors
	 * @throws Exception Exception
	 */
	Trick(String nameParam, String resRockParam, String resPaperParam, 
			String resScissorsParam) {
		this.name = nameParam;
		this.resRock = resRockParam;
		this.resPaper = resPaperParam;
		this.resScissors = resScissorsParam;
	}
	
	/**
	 * @return name Name of the trick
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * @return resRock Result against rock
	 */
	public String getResRock() {
		return resRock;
	}
	
	/**
	 * @return resPaper Result against paper
	 */
	public String getResPaper() {
		return resPaper;
	}
	
	/**
	 * @return resScissors Result against scissors
	 */
	public String getResScissors() {
		return resScissors;
	}
}
