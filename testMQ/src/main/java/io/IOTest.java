package io;

import java.io.*;

public class IOTest {
    public static void main(String[] args) throws IOException{
//        test01();
//        test02();
//        test03();
//        test04();
//        test05();
//        test06();
        test07();
    }


    public static void test01() throws IOException{
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("请输入一个字符");
        char c;
        c = (char)bufferedReader.read();
        System.out.println("你输入的字符为:"+c);
    }

    public static void test02() throws IOException{
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("请输入一个字符，按q结束");
        char c;
        do{
            c = (char)bufferedReader.read();
            System.out.println("你输入的字符为："+c);
        }while (c != 'q');
    }

    public static void test03() throws IOException{
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("请输入一行字符");
        String str = bufferedReader.readLine();
        System.out.println("你输入的字符为："+str);
    }

    public static void test04() throws IOException{
        byte [] bytes = {12,21,34,11,13};
        FileOutputStream fileOutputStream = new FileOutputStream(new File("").getAbsoluteFile()+"/src/main/java/io/test.txt");
        fileOutputStream.write(bytes);
        fileOutputStream.close();
    }

    public static void test05() throws IOException{
        FileInputStream fileInputStream = new FileInputStream(new File("").getAbsoluteFile()+"/src/main/java/io/test.txt");
        int c;
        //当.read()等于-1的时候，就是说没有字节了。
        while ((c=fileInputStream.read())!= -1){
            System.out.println(c);
        }
    }

    public static void test06() throws IOException{
        FileWriter fileWriter = new FileWriter(new File("").getAbsoluteFile()+"/src/main/java/io/test.txt");
        fileWriter.write("Hello,world! \n 欢迎你！");
        fileWriter.write("不会覆盖原来的内容 \n");

        fileWriter.append("并不是追加内容！ \n");
        fileWriter.flush();
        System.out.println("文件的默认编码格式为："+fileWriter.getEncoding());
        fileWriter.close();
    }

    public static void test07() throws IOException{
        FileReader fileReader = new FileReader(new File("").getAbsoluteFile()+"/src/main/java/io/test.txt");
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String str;
        while ((str=bufferedReader.readLine())!=null){
            System.out.println(str);
        }
    }

}
