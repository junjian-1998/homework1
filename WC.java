
/**
 * @author 我的文档
 */
package WC;

import java.io.File;
import java.io.FileNotFoundException; 
import java.io.FileReader;
import java.io.IOException; 
import java.util.Scanner;

public class WC {

public static void main(String[] args) {
	// TODO Auto-generated method stub
	Scanner scanner = new Scanner(System.in);
	System.out.println("请输入文件完整路径：");
	File file = new File(scanner.nextLine());
	if(file.exists() == false)
	{
		System.out.println("文件不存在");
		return;
	}
	if(file.canRead() == false)
	{
		System.out.println("文件不可读");
		return;
	}
	FileReader fr = null;
	try {
		fr = new FileReader(file);
	    } 
	catch (FileNotFoundException e) {
		// TODO 自动生成的 catch "
		e.printStackTrace();
	}
	Scanner scanner2=new Scanner(System.in);
	System.out.println("请输入要执行的操作：\n-c 字符总数  -l 行数  -w 单词总数");
	/*将要执行的操作以字符串的形式输入并用空格隔开 */
	String string=new String(scanner2.nextLine());
	String[] strings=string.split(" ");//将输入的字符串以空格分割成字符串数组。
	int flag=0;//用来判断字母的连续性
	int a;
	int chars= 0;
	int words = 0;
	int rows = 0;
	int length=strings.length;
	try {
		while((a=fr.read())!=-1){
			/*依次扫描每个字符，如果是字母,当出现连续两个字母时，flag++，
			 * 直到最后一个字符不为字母，则words++,flag置0。*/
			if((a>='A'&&a<='Z')||(a>='a'&&a<='z')){
				flag++;
			}
			if(flag>=2&&(!((a>='A'&&a<='Z')||(a>='a'&&a<='z')))){
				words++;
				flag=0;
			}
			if(flag<2&&(!((a>='A'&&a<='Z')||(a>='a'&&a<='z')))){
				flag=0;
			}
			if(a=='\n'){
				rows++;//遇到换行符，rows++.
			}
			if(a!=' '&&a!='\n')chars++;//空格和换行符均不算字符。
		}
	} catch (IOException e) {
		// TODO 自动生成的 catch 块
		e.printStackTrace();
	}
/***遍历字符串输出进行输出***/
	for (int i = 0; i <length; i++) {
		if(strings[i].equals("-c")) {
			System.out.println("字符总数："+chars);
		}
		if(strings[i].equals("-l")) {
			System.out.println("行数："+rows);
		}
		if(strings[i].equals("-w")) {
			System.out.println("单词总数："+words);
		}
	}

}
}