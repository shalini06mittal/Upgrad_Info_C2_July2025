package com.web.SpringBootWebDemo.actuator;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.endpoint.annotation.DeleteOperation;
import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.boot.actuate.endpoint.annotation.Selector;
import org.springframework.boot.actuate.endpoint.annotation.WriteOperation;
import org.springframework.stereotype.Component;

@Endpoint(id="releaseNotes")
@Component

public class ReleaseNotesEndpoint {

	@Autowired 
	private ReleaseNotesDataRepository releaseNotesDataRepository; 
	
	@ReadOperation 
	public List<ReleaseNote> getReleaseNotes() {
		return releaseNotesDataRepository.getReleaseNoteList();
	} 

	@WriteOperation 
	public ReleaseNote addReleaseNote(String version, String changeLogData) { 
		ReleaseNote releaseNote = new ReleaseNote(version, LocalDateTime.now(), changeLogData);
		return releaseNotesDataRepository.addReleaseNote(releaseNote); 
	} 
	
	@DeleteOperation 
	public void deleteReleaseNote(@Selector String version) {
		releaseNotesDataRepository.deleteReleaseNote(version); 
	}
}
