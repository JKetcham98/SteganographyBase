package pictureEdit;

public class MainRunner {
	public static void main(String[] args) {
		Picture pic = new Picture("BaseNaturePicture.png");
		//pic.encodeMessage("Hellodfghjkljhgfdvgbaskjdhf");
		pic.explore();
		System.out.println(pic.decodeMessage(5));
	}
	
	
	
	
	
	
	
	//binary conversion methods
	public static String decode(String str){
		return reverseString(binaryToText(str));
	}
	public static String reverseString(String str){
		String temp = "";
		for(int pos=str.length()-1;pos>=0;pos--){
			temp+=str.charAt(pos);
		}
		return temp;
	}
	public static String binaryToText(String num){
		String phrase = "";
		String temp="";
		for(int spot=0;spot<num.length();spot++){
			temp+=num.charAt(spot);
			if(temp.length()==8){
				phrase+=(char)toBaseTen(stringToInt((temp)));
				temp="";
			}
		}
		return phrase;
	}
	public static int stringToInt(String str){
		int num=0;
		for(int index=0;index<str.length();index++){
			num *= 10;
	        num += str.charAt(index) - 48;
		}
		return (int)num;
	}
	public static String textToBinary(String phrase){
		String num = "";
		for(int index=phrase.length()-1;index>=0;index--){
			if((int)(phrase.charAt(index))<128){//for letters our converter will be using 8 bit numbers,
				num+=0;//so our we need extra zeros in the front to decode correctly
			}
			if((int)(phrase.charAt(index))<64){//for spaces
				num+=0;
			}
			num += toBinary((int)(phrase.charAt(index)));//casts char value into an int, then turns it into binary,
		}//then concatenates that on a string called num
		return num;
	}
	public static int toBinary(int number){//can only accept values underneath 512 exclusive
		double temp=0;//temp value holder
		int place=1;//marks the place slot
		while(number>0){
			temp= (number%2)*Math.pow(10,place)+temp;//uses successive division to convert to binary
			number = number/2;
			place++;
		}
		return (int)temp/10;
	}
	public static int toBaseTen(int number){//converts binary to base 10
		double temp=0;//temp value holder
		int place=0;//marks the place slot
		while(number>0){
			temp= ((number%10))*Math.pow(2,place)+temp;//uses weighted multiplication to convert binary to base 10
			number = number/10;
			place++;
		}
		return (int)temp;
	}
}
