import java.awt.*;

class CustomNumberPuzzleControl extends NumberPuzzleControl {
	public int getWidth() {
		return 200;
	}
	public int getHeight() {
		return 250;
	}
	public int getXPosition() {
		return 200;
	}
	public int getYPosition() {
		return 200;
	}
	public String getTitle(){
		return "Number Puzzle";
	}
	public int getShuffleButtonFontSize() {
		return 12;
	}
	public int getNumbersFontSize() {
		return 12;
	}
	public Color getEmptyButtonColor() {
		return Color.WHITE;
	}
	public String getWinnerMessage() {
		return "Congrats, you have won!";
	}

	// The following three methods have to be written by the participants...

	public int handleButtonClicked(NumberPuzzleGame game){
		int emptyCellId = game.getEmptyCellId();
		Button buttonClicked = game.getButtonClicked();
		Button[] buttons = game.getButtons();
		
		//Your logic here		
		int i=0;
		for(Button but: buttons) {
			if(but == buttonClicked) {
				if((emptyCellId == (i+1))||(emptyCellId ==(i-1))||(emptyCellId == (i+4))||(emptyCellId ==(i-4))){
					swapButton(buttons[emptyCellId],buttonClicked);
					emptyCellId = i;
					break;
				}
			}
		i++;	
		}
		return emptyCellId;

	}
	public int[] getRandomNumbersForGrid() {
		int arr[] = new int[15];
		
		//Your logic here
		int i=0;
		while(i<15) {
		int a = getRandomNumber();
		if(a>0 && a<16) {
			int x=0;
			for(int j=0;j<i;j++) {
				if(a==arr[j]) {
					x=1;
					break;
				}
			}
			if(x==0) {
				arr[i]=a;
				i++;
			}
		}
		}
		
		return arr;
	}
	public boolean checkForWinner(Button[] buttons)
	{
		boolean winner = true;
		
		// Your Logic here
		int[] arr1 = getIntegerArrayOfButtonIds(buttons);
		int i=0;
		for(;i<15;i++) {
			if((i+1) !=arr1[i]){
				break;
			}
		}
		if(i==15) {
			winner=true;
		}
		else {
			winner=false;
		}

		return winner;
	}
}