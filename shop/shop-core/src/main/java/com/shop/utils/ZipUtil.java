package com.shop.utils;

import java.io.ByteArrayOutputStream;
import java.util.zip.DataFormatException;
import java.util.zip.Deflater;
import java.util.zip.Inflater;
/**  
*
* @Title:  ZipUtil.java   
* @Package com.shop.utils   
* @Description:    TODO(解压缩工具)   
* @author: jiazhenlong     
* @date:   2018年6月11日 下午4:13:05   
* @version V1.0 
* @Copyright: 2018 wehere All rights reserved. 
*/
public class ZipUtil {

  private static final ThreadLocal<Deflater> THREAD_LOCAL_ZIP = new ThreadLocal<Deflater>() {
    protected synchronized Deflater initialValue() {
      return new Deflater(Deflater.BEST_SPEED);
    }
  };

  private static final ThreadLocal<Inflater> THREAD_LOCAL_UNZIP = new ThreadLocal<Inflater>() {
    protected synchronized Inflater initialValue() {
      return new Inflater();
    }
  };

  /** 压缩时，结果缓冲区大小为输入的?分之一 **/
  private static final int ZIP_BUFFER_RATIO = 3;

  /** 解压时，结果缓冲区大小为输入的?倍 **/
  private static final int UNZIP_BUFFER_RATIO = 5;

  /** 缓冲区大小为?字节 **/
  private static final int BUFFER_SIZE = 1024 * 4;


  private ZipUtil() {

  }


  /**
  * 压缩数据
  * 
  * @param data
  * @return
  */
  public static final byte[] zip(byte[] data) {
    ByteArrayOutputStream baos = new ByteArrayOutputStream(data.length / ZIP_BUFFER_RATIO);

    Deflater zip = THREAD_LOCAL_ZIP.get();
    zip.setInput(data);
    zip.finish();

    int count;
    byte[] buffer = new byte[BUFFER_SIZE];
    do {
      count = zip.deflate(buffer);
      baos.write(buffer, 0, count);
    } while (!zip.finished());
    zip.reset();

    return baos.toByteArray();
  }


  /**
  * 解压缩数据
  * 
  * @param data
  * @return
  */
  public static final byte[] unzip(byte[] data) {
    ByteArrayOutputStream baos = new ByteArrayOutputStream(data.length * UNZIP_BUFFER_RATIO);

    Inflater unzip = THREAD_LOCAL_UNZIP.get();
    unzip.setInput(data);

    int count;
    byte[] buffer = new byte[BUFFER_SIZE];
    try {
      do {
        count = unzip.inflate(buffer);
        baos.write(buffer, 0, count);
      } while (!unzip.finished());
    } catch (DataFormatException e) {
      throw new RuntimeException(e);
    } finally {
      unzip.reset();
    }

    return baos.toByteArray();
  }
}
