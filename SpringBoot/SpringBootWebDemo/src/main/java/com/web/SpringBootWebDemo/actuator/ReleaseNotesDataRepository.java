package com.web.SpringBootWebDemo.actuator;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public class ReleaseNotesDataRepository {

	private final List<ReleaseNote> releaseNoteList; 
	public ReleaseNotesDataRepository() { 
		releaseNoteList = new ArrayList<>(); 
		releaseNoteList.add(new ReleaseNote("RN1", LocalDateTime.of(2023, 11,13,12,12,12),"Added by admin"));
		releaseNoteList.add(new ReleaseNote("RN2", LocalDateTime.of(2022, 12,1,12,12,12),"Added by user"));

	} 
	public List<ReleaseNote> getReleaseNoteList() { 
		return releaseNoteList; 
	} 
	public ReleaseNote addReleaseNote(ReleaseNote releaseNote) { 
		releaseNoteList.add(releaseNote); 
		return releaseNote; 
	} 
	public void deleteReleaseNote(String version) { 
		for (int i = 0; i < releaseNoteList.size(); i++) { 
			if(releaseNoteList.get(i).getVersion().equals(version)){
				releaseNoteList.remove(releaseNoteList.get(i)); 
				break; 
			}
		} 
	} 
}
