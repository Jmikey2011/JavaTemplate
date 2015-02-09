import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

/**
 * 
 * @author James Kelly
 * @description Creates a basic template java class with comments
 * 			and a basic structure.
 * @version 1.3
 *
 */
public class Template {

	// ======================================== Instance Variables

	private String fileName;
	private char c;
	private String lineBreak = "// ======================================== ";
	private String name,text;
	private String todo = "\n\t// Fill in with stuff.";
	private String[] lables1 = {"Instance Variables","Constructors","Methods","Getters / Setters","toString","Main"};
	private String[] lables2 = {todo,getBasicConstructor(),todo,todo,todo,getMainAuto()};
	private double version;

	// ======================================== Constructors

	public Template(String fileName, String name, String text, double version, String[] instanceVariables){
		setFileName(fileName);
		setText(text);
		setVersion(version);
		setInstanceVariables(instanceVariables);
		setUpFile();
	
	}
	

	/**
	 * Constructs a java file with a specified fileName, name, text, version
	 * @param fileName (String)
	 * @param name (String)
	 * @param text (String)
	 * @param version (double)
	 */
	public Template(String fileName, String name, String text, double version){
		this(fileName,name,text,version);
	}// end constructor

	/**
	 * Constructs a basic java class file
	 * @param fileName
	 */
	public Template(String fileName){
		this(fileName,"[Name]","[Text]",1.0);
	}// end constructor
	
	// Different Types of Files to setup
	
	

	// ======================================== Methods

	private void setUpFile() {

		try {
			PrintWriter pw = new PrintWriter(new File(fileName + ".java"));
			pw.print(getTopComments());
			pw.print("\npublic class " + fileName+ "{" + getBody());
			pw.print("\n}// end "+fileName);
			pw.close();
		} catch (FileNotFoundException e) {e.printStackTrace();}// end catch
	}// end setUpFile

	// ======================================== Getters / Setters

	/**
	 * Returns the Body of the program
	 * @return (String)
	 */
	private String getBody(){
		String temp = "\n";
		for(int i = 0; i < lables1.length; i++)
			temp += "\n\t" + lineBreak + lables1[i] + "\n\t\t" + lables2[i] + "\n";
		return temp;
	}// end 

	/**
	 * Returns the top javadoc comments
	 * @return (String)
	 */
	private String getTopComments(){
		return String.format("/** \n *\n * @author %s\n * @description %s\n * @version %.1f\n *\n*/", name,text,version);
	}// end getTopComments

	/**
	 * Returns the basic constructor for the class
	 * @return (String)
	 */
	private String getBasicConstructor(){
		return "\n\tpublic " + fileName + "(){"
				+ "\n\t\t//Fill in with methods."
				+ "\n\t}// end constructor";
	}//end getBasicConstructor
	

	/**
	 * Returns the basic main method
	 * @return (String)
	 */
	private String getMainAuto() {
		return "\n\t/**\n\t * Executes the program \n\t * @param args\n\t*/"
				+ "\n\t public static void main(String [] args){ "
				+ "\n\t\t// Calls the constructor to run the program"
				+ "\n\n\t}// end main\n";
	}// end getMainAuto

	/**
	 * Sets the fileName of the object 
	 * @param fileName2 (String)
	 */
	private void setFileName(String fileName2) {
		if(fileName2.charAt(0) > 90){
			c = (char) (c - 32);
			fileName2 = c + fileName.substring(1);
			fileName = fileName2.trim();
		}// end if
		else
			fileName = fileName2.trim();
	}// end FileName
	
	private void setText(String text2) {
		text = text2.trim();
	}// end setText

	private void setVersion(double version2) {
		if(version2 < 0)
			version = 1.0;
		else
			version = version2;
	}// end setVersion

}// end Template
