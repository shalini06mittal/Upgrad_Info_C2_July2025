package com.web.SpringBootWebDemo.actuator;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Data
@AllArgsConstructor 
@NoArgsConstructor
public class ReleaseNote {

	private String version; 
	private LocalDateTime date; 
	private String changeLogData;
}
