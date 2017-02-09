package actionOnSentence;

public class ActionOnSentence {
	
	
	public String removeOtherChars(String sentence) {
		StringBuilder temporaryResult = new StringBuilder();
		for (int i = 0; i < sentence.length(); i++) {
			char sign = sentence.charAt(i);
			if (isAcceptableCalculateChar(sign)) {
				temporaryResult.append(sign);
				}
		}
		if(temporaryResult.length()==0){
			temporaryResult.append(0);
		}
		String result = temporaryResult.toString();
		return result;
	}

	private boolean isAcceptableCalculateChar(char sign) {
		boolean isAcceptable = false;
		byte index = (byte) sign;
		if (index >= 48 && index <= 58) {
			isAcceptable = true;
		}
		return isAcceptable;
	}
}
