
/**
 * @param path
 * @return String
 * @description 将文件转base64字符串
 * @date 2018年3月20日
 * @author changyl
 */

import java.io.*;
import java.util.Base64;//我这里的base64来自于jdk1.8


public class Main {
    public static String fileToBase64(String path) {
        String base64 = null;
        InputStream in = null;
        try {
            File file = new File(path);
            in = new FileInputStream(file);
            byte[] bytes = new byte[(int) file.length()];
            in.read(bytes);
            base64 = Base64.getEncoder().encodeToString(bytes);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return base64;
    }

    public static void base64ToFile(String base64, String fileName) {
        File file = null;
        //创建文件目录
        String filePath = "";
        File dir = new File(filePath);
        if (!dir.exists() && !dir.isDirectory()) {
            dir.mkdirs();
        }
        BufferedOutputStream bos = null;
        java.io.FileOutputStream fos = null;
        try {
            byte[] bytes = Base64.getDecoder().decode(base64);
            file = new File(filePath + "" + fileName);
            fos = new java.io.FileOutputStream(file);
            bos = new BufferedOutputStream(fos);
            bos.write(bytes);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (bos != null) {
                try {
                    bos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    public static void main(String[] args) {
        String aa =  fileToBase64("/Users/yoli/Desktop/youke.png");
        System.out.println(aa);
//        base64ToFile(fileToBase64("/Users/yoli/Desktop/youke.png"), "/Users/yoli/Desktop/youke2.png");
    }
}
