package com.example.demo.Dto;
import java.io.Serializable;
import java.util.Map;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class NotificationEventDto implements Serializable{

	    private String eventType;  
	    private String email;
	    private String phone;
	    private Map<String, Object> data;
}
