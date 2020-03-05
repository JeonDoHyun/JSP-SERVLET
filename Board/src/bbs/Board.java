package bbs;

public class Board {
	private int boardID;
	private String boardTitle;
	private String userID;
	private String boardDate;
	private String boardContent;
	private int boardAvailable;

	public int getBoardID() {
		return boardID;
	}

	public void setBoardID(int boardID) {
		this.boardID = boardID;
	}

	public String getBoardTitle() {
		return boardTitle;
	}

	public void setBoardTitle(String boardTitle) {
		this.boardTitle = boardTitle;
	}

	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}

	public String getBoardDate() {
		return boardDate;
	}

	public void setBoardDate(String boardDate) {
		this.boardDate = boardDate;
	}

	public String getBoardContent() {
		return boardContent;
	}

	public void setBoardContent(String boardContent) {
		this.boardContent = boardContent;
	}

	public int getBoardAvailable() {
		return boardAvailable;
	}

	public void setBoardAvailable(int boardAvailable) {
		this.boardAvailable = boardAvailable;
	}

	public Board(int boardID, String boardTitle, String userID, String boardDate, String boardContent,
			int boardAvailable) {
		super();
		this.boardID = boardID;
		this.boardTitle = boardTitle;
		this.userID = userID;
		this.boardDate = boardDate;
		this.boardContent = boardContent;
		this.boardAvailable = boardAvailable;
	}

	public Board() {
		// TODO Auto-generated constructor stub
	}

}
