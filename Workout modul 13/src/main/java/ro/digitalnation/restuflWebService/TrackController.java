package ro.digitalnation.restuflWebService;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ro.digitalnation.activitati.Activitate;
import ro.digitalnation.activitati.Curs;
import ro.digitalnation.basic.Explorer;
import ro.digitalnation.basic.Persoana;
import ro.digitalnation.basic.Trainer;
import ro.digitalnation.structure.Track;

@RestController
public class TrackController {

	private Track track = new Track();
	
	@GetMapping("/curs")
	public Curs getCurs() {
		return track.getCurs();
	}
	
	@GetMapping("/exploreri")
	public ArrayList<Persoana> getExploreri(){
		return track.getCurs().getExploreri();
	}
	
	@GetMapping("/trainer")
	public Persoana getTrainer() {
		return track.getCurs().getTrainer();
	}
	
	@GetMapping("/activitati")
	public Iterable<String> getActivitati(){
		return track.getCurs().getActivitati().keySet();
	}
	
	@GetMapping("/activitate")
	public String getActivitateByName(@RequestParam String name) {
		return track.getCurs().getActivitati().get(name).toString();
	}
	
	@GetMapping("/explorerIds")
	public List<String> getExplorerIds() {
	    List<String> explorerIds = new ArrayList<>();

	    for (Persoana persoana : track.getCurs().getExploreri()) {
	        if (persoana instanceof Explorer) {
	            Explorer explorer = (Explorer) persoana;
	            explorerIds.add(explorer.obtineIdentificator());
	        }
	    }

	    return explorerIds;
	}
	
	@GetMapping("/explorer/{id}")
	public Persoana getExplorerById(@PathVariable String id) {
	    ArrayList<Persoana> explorers = track.getCurs().getExploreri();
	    for (Persoana explorer : explorers) {
	        if (explorer.obtineIdentificator().equals("explorer_" + id)) {
	            return explorer;
	        }
	    }
	    return null;
	}
	
	@PostMapping("/addExplorer")
	 public String addExplorer(@RequestBody Explorer explorer) {
		 String explorerId = explorer.obtineIdentificator();

		     for (Persoana persoana : track.getCurs().getExploreri()) {
		        if (persoana instanceof Explorer) {
		            Explorer existingExplorer = (Explorer) persoana;
		            if (existingExplorer.obtineIdentificator().equals(explorerId)) {
		                return "Explorer-ul cu ID " + explorerId + " exista deja in lista exploratorilor.";
		            }
		        }
		    }

		     track.getCurs().getExploreri().add(explorer);
		    return "Explorer adaugat cu succes!";
		}
	 
	 @PostMapping("/populateTrack")
	 public String populateTrack(@RequestBody Map<String, Object> trackData) {
	     // Extract data for new Curs
	     Map<String, Object> cursData = (Map<String, Object>) trackData.get("curs");
	     String nume = (String) cursData.get("nume");
	     String dificultate = (String) cursData.get("dificultate");
	     int cost = (int) cursData.get("cost");

	     Curs newCurs = new Curs(nume, dificultate, cost);

	     track.setCurs(newCurs);

	     Map<String, Activitate> activitatiData = (Map<String, Activitate>) trackData.get("activitati");
	     LinkedHashMap<String, Activitate> existingActivitati = track.getCurs().getActivitati();

	     for (Map.Entry<String, Activitate> entry : activitatiData.entrySet()) {
	         String activityName = entry.getKey();
	         Activitate activityData = (Activitate) entry.getValue();

	         existingActivitati.put(activityName, activityData);
	     }

	     List<Map<String, Object>> trainersData = (List<Map<String, Object>>) trackData.get("trainers");
	     for (Map<String, Object> trainerData : trainersData) {
	         String numeTrainer = (String) trainerData.get("numeTrainer");
	         String prenumeTrainer = (String) trainerData.get("prenumeTrainer");
	         String orasTrainer = (String) trainerData.get("oras");
	         Integer varstaTrainer = (Integer) trainerData.get("varsta");
	         boolean casatoritaTrainer = (boolean) trainerData.get("casatorita");

	         Trainer newTrainer = new Trainer(numeTrainer, prenumeTrainer, orasTrainer, varstaTrainer, casatoritaTrainer);

	         track.getCurs().getExploreri().add(newTrainer);
	     }
	     
	     List<Map<String, Object>> explorersData = (List<Map<String, Object>>) trackData.get("explorers");
	     for (Map<String, Object> explorerData : explorersData) {
	         String numeExplorer = (String) explorerData.get("numeExplorer");
	         String prenumeExplorer = (String) explorerData.get("prenumeExplorer");
	         String orasExplorer = (String) explorerData.get("oras");
	         Integer varstaExplorer = (Integer) explorerData.get("varsta");
	         boolean casatoritaExplorer = (boolean) explorerData.get("casatorita");

	         Explorer newExplorer = new Explorer(numeExplorer, prenumeExplorer, orasExplorer, varstaExplorer, casatoritaExplorer);

	         track.getCurs().getExploreri().add(newExplorer);
	     }

	     return "Track populat cu succes!";
	 }

	}