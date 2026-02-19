package com.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.SequenceGenerator;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
public class JobSeeker implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@SequenceGenerator(sequenceName = "gen1",initialValue = 1000000,allocationSize = 10)
	@GeneratedValue(generator = "gen1",strategy = GenerationType.SEQUENCE)
	private Integer jsid;
	
	@Column(length = 30)
	@NonNull
	private String jsname;
	@Column(length = 30)
	@NonNull
	private String jsaddrs;
	@Lob
	@NonNull
	private byte[] photo;
	@Lob
	@NonNull
	private char[] resume;

}
