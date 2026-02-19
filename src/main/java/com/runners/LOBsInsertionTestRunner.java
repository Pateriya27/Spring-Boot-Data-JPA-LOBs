package com.runners;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

import com.entity.JobSeeker;
import com.service.IJobSeekerMgmtService;

//@Component
public class LOBsInsertionTestRunner implements CommandLineRunner {

	@Autowired
	private IJobSeekerMgmtService service;

	@Override
	public void run(String... args) throws Exception {
		
		try(Scanner sc=new Scanner(System.in);){
			
			System.out.print("Enter JobSeeker Name : ");
			String name=sc.nextLine();
			System.out.print("Enter JobSeeker Addrs: ");
			String addrs=sc.nextLine();
			System.out.print("Enter JobSeeker Photo path: ");
			String photoPath=sc.nextLine().trim();
			System.out.print("Enter JobSeeker Resume path: ");
			String resumePath=sc.nextLine().trim();
			byte[] photoContent=null;
			char[] resumeContent=null;
			try(FileInputStream fis=new FileInputStream(photoPath);
					BufferedReader br=new BufferedReader(new FileReader(resumePath))){
				
				
				photoContent=fis.readAllBytes();
				File f=new File(resumePath);
				resumeContent=new char[(int) f.length()];
				br.read(resumeContent);
				
			}catch (Exception e) {
				e.printStackTrace();
			}
			
			JobSeeker js=new JobSeeker(name,addrs,photoContent,resumeContent);
			String msg = service.registerJobSeeker(js);
		    System.out.println(msg);
			
		}catch(Exception e)
		{
			
		}
		

	}

}
