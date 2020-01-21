/**
 * 
 */
package dhcc.com.cn.util;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Arrays;

import javax.imageio.ImageIO;
import javax.imageio.ImageReadParam;
import javax.imageio.ImageReader;
import javax.imageio.stream.ImageInputStream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author dhcc.com.cn
 * create date: 2019年9月18日 下午2:29:12
 */
public class ImageClip {

    private Logger log = LoggerFactory.getLogger(getClass());

    private static String DEFAULT_CUT_PREVFIX = "icon_";

    /**
     * Description: 依据原图与裁切size截取局部图片
     * @param srcImg 源图片
     * @param output 图片输出流
     * @param rect 须要截取部分的坐标和大小
     */
    public void cutImage(File srcImg, OutputStream output,java.awt.Rectangle rect) {
        if (srcImg.exists()) {
            FileInputStream fis = null;
            ImageInputStream iis = null;
            try {
                fis = new FileInputStream(srcImg);
                // ImageIO 支持的图片类型 : [BMP, bmp, jpg, JPG, wbmp, jpeg, png, PNG,
                // JPEG, WBMP, GIF, gif]
                String types = Arrays.toString(ImageIO.getReaderFormatNames())
                        .replace("]", ",");
                String suffix = null;
                // 获取图片后缀
                if (srcImg.getName().indexOf(".") > -1) {
                    suffix = srcImg.getName().substring(srcImg.getName().lastIndexOf(".") + 1);
                }// 类型和图片后缀所有小写。然后推断后缀是否合法
                if (suffix == null
                        || types.toLowerCase().indexOf(suffix.toLowerCase() + ",") < 0) {
                    log.error("Sorry, the image suffix is illegal. the standard image suffix is {}."+ types);
                    return;
                }
                // 将FileInputStream 转换为ImageInputStream
                iis = ImageIO.createImageInputStream(fis);
                // 依据图片类型获取该种类型的ImageReader
                ImageReader reader = ImageIO.getImageReadersBySuffix(suffix).next();
                reader.setInput(iis, true);
                ImageReadParam param = reader.getDefaultReadParam();
                param.setSourceRegion(rect);
                BufferedImage bi = reader.read(0, param);
                ImageIO.write(bi, suffix, output);
                log.info("图片生成成功，请到文件夹下查看");
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    if (fis != null)
                        fis.close();
                    if (iis != null)
                        iis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } else {
            log.warn("the src image is not exist.");
        }
    }


    //生成目标文件路径
    public String cutImage(File srcImg, String destImgPath,java.awt.Rectangle rect) {
        File destImg = new File(destImgPath);
        if (destImg.exists()) {
            String p = destImg.getPath();
            try {
                if (!destImg.isDirectory())
                    p = destImg.getParent();
                if (!p.endsWith(File.separator))
                    p = p + File.separator;
                cutImage(srcImg,new java.io.FileOutputStream(p + DEFAULT_CUT_PREVFIX+ "_"+ srcImg.getName()), rect);
                return p + DEFAULT_CUT_PREVFIX+ "_"+ srcImg.getName();
            } catch (FileNotFoundException e) {
                log.warn("the dest image is not exist.");
            }
        } else
            log.warn("the dest image folder is not exist.");
        	return null;
    }


    public String cutImage(String srcImg, String destImg, int x, int y, int width,
            int height) {
        String imgUrl = cutImage(new File(srcImg), destImg, new java.awt.Rectangle(x, y, width, height));
        return imgUrl;
    }

}