/**
 * 
 */
package dhcc.com.cn.util;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;

import javax.imageio.ImageIO;

import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGImageEncoder;

/**
 * @author dhcc.com.cn
 * create date: 2019��9��19�� ����4:27:55
 */
public class ReduceImg {
  
    public static void reduceImg(String imgsrc, String imgdist, int widthdist, int heightdist, Float rate) {
        try {
            File srcfile = new File(imgsrc);
            if (!srcfile.exists()) {
                System.out.println("�ļ�������");
            }
            if (rate != null && rate > 0) {
                int[] results = getImgWidthHeight(srcfile);
                if (results == null || results[0] == 0 || results[1] == 0) {
                    return;
                } else {
                    widthdist = (int) (results[0] * rate);
                    heightdist = (int) (results[1] * rate);
                }
            }
            Image src = ImageIO.read(srcfile);

            BufferedImage tag = new BufferedImage((int) widthdist, (int) heightdist, BufferedImage.TYPE_INT_RGB);

            tag.getGraphics().drawImage(src.getScaledInstance(widthdist, heightdist, Image.SCALE_SMOOTH), 0, 0, null);

            FileOutputStream out = new FileOutputStream(imgdist);
            JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(out);
            encoder.encode(tag);
            out.close();
            System.out.println("压缩成功");
        } catch (Exception ef) {
            ef.printStackTrace();
        }
    }

    public static int[] getImgWidthHeight(File file) {
        InputStream is = null;
        BufferedImage src = null;
        int result[] = { 0, 0 };
        try {
            is = new FileInputStream(file);
            src = ImageIO.read(is);
            result[0] =src.getWidth(null); 
            result[1] =src.getHeight(null);
            is.close();
        } catch (Exception ef) {
            ef.printStackTrace();
        }

        return result;
    }

}