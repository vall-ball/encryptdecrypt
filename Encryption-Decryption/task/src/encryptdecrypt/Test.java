package encryptdecrypt;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Test {

    public static void main(String[] args) {
        File baseDir = new File("D:\\programming\\basedir");
        List<File> files = new ArrayList<>();
        List<File> answer = listFilesForFolder(files, baseDir);
        System.out.println(answer.size());

        List<File> emptyFolders = new ArrayList<>();
        for (File f : answer) {
            if (f.isDirectory() && f.list().length == 0) {
                emptyFolders.add(f);
            }
        }


    for (File f : emptyFolders) {
        System.out.print(f.getName() + " ");
    }


      /*  File[] files = baseDir.listFiles();
        int max = files[0].listFiles().length;
        String name = files[0].getName();
        for (File f : files) {
            if (f.listFiles().length > max) {
                name = f.getName();
                max = f.listFiles().length;
            }
        }
        System.out.println(name + " " + max);*/
    }

     public void moveToSpam(String username, File msg) {
         String pathToSpam = username + File.separator + "spam";

         File spamDirectory = new File(pathToSpam);
          if (!spamDirectory.exists()) {
                    spamDirectory.mkdir();
               }

          File spamMsg = new File(pathToSpam + File.separator + msg.getName());
         msg.renameTo(spamMsg);
         }
    private static int getNesting(File file) {
        String name = file.getAbsolutePath();
        //System.out.println(name);
        int answer = 0;
        for (char i : name.toCharArray()) {
            if (i == '\\') {
                answer++;
            }
        }
        return answer;
    }

    public static List<File> listFilesForFolder(List<File> list, File folder) {
        for (File file : folder.listFiles()) {
            if (file.isDirectory() && file.list().length != 0) {
                list.add(file);
                listFilesForFolder(list, file);
            } else {
                list.add(file);
                }
            }
        return list;
        }




}
