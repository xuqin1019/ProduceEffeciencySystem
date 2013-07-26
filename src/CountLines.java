import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class CountLines {
	public static void main(String[] args) {
		// File fileDir = new File(
		// "D:\\workFile\\MyEclipseWorkspaceWin\\VideoGateway6");
		File fileDir = new File(
		// "/usr/share/dataService/dataService2/dataService2/hao/hadoop/");
				"E:\\桌面\\produceEffeciencySystem\\src");
                
		BufferedReader reader = null;
		String ls = null;
		ArrayList<File> fileList = new ArrayList<File>();
		ArrayList<File> pathList = new ArrayList<File>();
		int countFile = 0;
		int countLine = 0;
		int countChar = 0;
		getFiles(fileDir, fileList, pathList);
		for (int i = 0; i < fileList.size(); i++) {
			/*
			 * if ((fileList.get(i).getName().endsWith(".java")) ||
			 * (fileList.get(i).getName().endsWith(".py")) ||
			 * (fileList.get(i).getName().endsWith(".wsgi")) ||
			 * (fileList.get(i).getName().endsWith(".jsp")) ||
			 * (fileList.get(i).getName().endsWith(".js")) ||
			 * (fileList.get(i).getName().endsWith(".css")) ||
			 * (fileList.get(i).getName().endsWith(".html")) ||
			 * (fileList.get(i).getName().endsWith(".xml")) ||
			 * (fileList.get(i).getName().endsWith(".txt")) ||
			 * (fileList.get(i).getName().endsWith(".sql"))) {
			 */
			if (true) {
				countFile++;
				try {
					reader = new BufferedReader(new FileReader(fileList.get(i)));
                                        
					while ((ls = reader.readLine()) != null) {
                                                if(!ls.trim().equals("")) {
                                                    countLine++;
                                                    countChar = countChar + ls.length();
                                                }
					}
				} catch (IOException e) {
					e.printStackTrace();
				} finally {
					try {
						reader.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		}
		/*
		 * System.out.println("paths:" + (pathList.size() - 926));
		 * System.out.println("files:" + (countFile - 6158));
		 * System.out.println("lines:" + (countLine - 3761787));
		 * System.out.println("chars:" + (countChar - 175782798));
		 */
		System.out.println("paths:" + pathList.size());
		System.out.println("files:" + countFile);
		System.out.println("lines:" + countLine);
		System.out.println("chars:" + countChar);
	}

	public static void getFiles(File path, ArrayList<File> fileList,
			ArrayList<File> pathList) {
		// System.out.println("fileList size is:" + fileList.size());
		for (File one : path.listFiles()) {
			if (one.isDirectory()) {
				pathList.add(one);
				getFiles(one, fileList, pathList);
			} else {
				if (one.getName().endsWith(".java")) {
					System.out.println(one);
					fileList.add(one);
				}
			}
		}
	}
}