package com.wzh.secondshop.utils;

import org.hibernate.validator.internal.util.privilegedactions.GetResource;

import java.io.File;

/**
 * 文件检查
 * 
 * @author WEN
 *
 */
public class FileCheck {
	/**
	 * 检查物品文件是否存在
	 * 
	 * @param filePath
	 * @return
	 */
	public String checkGoodFolderExist(String filePath) {
		Boolean success = false;
		String classpath = FileCheck.class.getResource("/").getPath()
				.replaceFirst("/", "");

		String path = classpath.replaceAll("/target/classes/", "/src/main/webapp") +""+ filePath;
		path = path.replaceAll("%20", " ");
		File file = new File(path);
		System.out.println("路径1"+path);
		success = checkFileExist(file);
		if (success) {
			return path + "/";
		} else {
			return "";
		}
	}

	public String checkGoodFolderExist1(String filePath) {
		Boolean success = false;
		String classpath = FileCheck.class.getResource("/").getPath()
				.replaceFirst("/", "");

		String path = classpath.replaceAll("/target/wzh-secondshop/WEB-INF/classes/", "/src/main/webapp") +""+ filePath;
		path = path.replaceAll("%20", " ");
		File file = new File(path);
		System.out.println("路径"+path);
		success = checkFileExist(file);
		if (success) {
			return path + "/";
		} else {
			return "";
		}
	}

	/**
	 * 检查文件是否存在
	 * 
	 * @param file
	 * @return
	 */
	public Boolean checkFileExist(File file) {
		if (file.exists()) {
			System.out.println("文件夹已存在！");
			return true;
		} else {
			System.out.println("文件夹不存在，正在创建！");
			boolean mkdirs = file.mkdirs();
			if (mkdirs) {
				System.out.println("文件夹创建成功！");
				return true;
			} else {
				System.out.println("创建失败！");
				return false;
			}
		}
	}
}
