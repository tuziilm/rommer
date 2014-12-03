package com.zhanghui.rommer.common;

import com.google.common.io.Files;
import com.zhanghui.rommer.exception.UploadException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UpLoads {
	private final static Log log=LogFactory.getLog(UpLoads.class);
	/**
	 * �����ϴ��ļ�
	 * @param files
	 * @param ut
	 * @return
	 * @throws UploadException
	 */
	public static List<String> upload(List<MultipartFile> files,UploadType ut) throws UploadException{
		List<String> paths=new ArrayList<String>(files.size());
		for(MultipartFile file : files){
			paths.add(upload(file, ut));
		}
		return paths;
	}
	/**
	 * �ϴ�
	 * @param file  �ϴ��ļ�����
	 * @return  �����ļ��ϴ���·��
	 * @throws Exception
	 */
	public static String upload(MultipartFile file,UploadType ut) throws UploadException{
		if(file==null || file.isEmpty()){
			throw new UploadException("�ϴ��ļ�Ϊ�գ�");
		}
		String oriFilename = file.getOriginalFilename();
		String extension=Files.getFileExtension(oriFilename);
		if(!ut.supportFileType(extension)){
			throw new UploadException("�ϴ��ļ���ʽ����ȷ��֧�ֵĸ�ʽΪ��"+ut.getFileTypesString());
		}
		if(!ut.supportFileSize(file.getSize())){
			throw new UploadException("�ϴ��ļ�̫���ļ�����"+ut.getMaxSize()+"���ڣ�");
		}
		String relativeFilename = prepareUpload(ut, oriFilename, extension);
		
		try {
			file.transferTo(new File(Config.UPLOAD_ROOT_DIR+"/"+relativeFilename));
			return relativeFilename;
		} catch (Exception e) {
			throw new UploadException("�ļ��ϴ�ʧ�ܣ�");
		}
	}
	/**
	 * ׼���ϴ��ļ�
	 * @param ut
	 * @param oriFilename
	 * @param extension
	 * @return
	 */
	public static String prepareUpload(UploadType ut, String oriFilename,
			String extension) {
		Date date=new Date();
		String relativeDir=ut.getModule()+"/"+new SimpleDateFormat("yyyy/MM").format(date);
		String relativeFilename=relativeDir+"/"+new SimpleDateFormat("ddHHmmssSSS").format(date)+"-"+oriFilename.hashCode()+"."+extension;
		//�ѵ�ǰϵͳʱ����꣬����Ϊ�ļ��е����ƣ��������ڣ��򴴽�
		File dir=new File(Config.UPLOAD_ROOT_DIR+"/"+relativeDir);
		//�жϸ��ļ�·���Ƿ���ڣ���������ڣ��򴴽�
		if(!dir.exists()){
			dir.mkdirs();
		}
		return relativeFilename;
	}
	/**
	 * ��������ɾ��ָ��·���µ��ļ�
	 * @param filePathList  �ļ�·������  List<String>
	 * @throws Exception 
	 */
	public static void deleteFileQuitely(List<String> filePathList)throws Exception{
		try {
			for(String path:filePathList){
				File dir=new File(Config.UPLOAD_ROOT_DIR+"/"+path);
				if(dir.exists()){
					dir.delete();
				}
			}
		} catch (Exception e) {
			log.error(e);
		}
	}
}
