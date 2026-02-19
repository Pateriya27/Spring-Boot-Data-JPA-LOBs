package com.runners;

import java.io.FileOutputStream;
import java.io.FileWriter;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.entity.JobSeeker;
import com.service.IJobSeekerMgmtService;

@Component
public class LOBsRetrievalTestRunner implements CommandLineRunner {

	@Autowired
	private IJobSeekerMgmtService service;

	@Override
	public void run(String... args) throws Exception {
		
		try(Scanner sc=new Scanner(System.in);
				FileOutputStream fos=new FileOutputStream("Retrieved_Photo.jpg");
				FileWriter writer=new FileWriter("Retrieved_Resume.txt")){
		  System.out.print("Enter Job Seeker Id : ");
		  int id=Integer.parseInt(sc.nextLine());
		  JobSeeker js = service.findJobSeekerById(id);
		  System.out.println(js.getJsid()+" :: "+js.getJsname()+" :: "+js.getJsaddrs());
		  byte[] photo=js.getPhoto();
		  char[] resume=js.getResume();
		  
		  fos.write(photo);
		  writer.write(resume);
		  
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		

	}

}
