package pictureEdit;

public class MainRunner {
	public static void main(String[] args) {
		//Picture pic = new Picture("BaseNaturePicture.jpg");
		//pic.explore();
		
		System.out.println(textToBinary("How are you today?"));
		//System.out.println(binaryToText("0100000100100000011001110010000000111010"));
		System.out.println(textToBinary("A g :"));
		System.out.println(stringToInt("1001"));
		
	}
	
	
	
	
	
	public static String binaryToText(String num){//broken
		String phrase = "";
		String temp="";
		for(int spot=0;spot<num.length();spot++){
			temp+=spot;
			if(temp.length()==8){
				phrase+=(char)(stringToInt((temp)));
			}
		}
		return phrase;
	}
	public static int stringToInt(String str){//broken
		int num=0;
		for(int index=0;index<str.length();index++){
			num+= (int)(str.charAt(index)*Math.pow(10,index));
		}
		return num;
	}
	
	public static String textToBinary(String phrase){
		String num = "";
		for(int index=0;index<phrase.length();index++){
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
}
