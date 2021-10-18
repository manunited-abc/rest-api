package laptrinhdotnet.restful_api.controller;
import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import laptrinhdotnet.restful_api.model.Subject;



@RestController
public class UserController {
	private List<Subject> subjects = new ArrayList<Subject>();
	public UserController() {
//		subjects.add(new Subject("1", "214372","Lập trình .NET", 4));
//		subjects.add(new Subject("2", "214462","Lập trình Web", 4));
//		subjects.add(new Subject("3", "214373","Nhập môn trí tuệ nhân tạo", 4));
//		subjects.add(new Subject("4", "214252","Lập trình mạng", 4));
//		subjects.add(new Subject("5", "214252","Lập trình nâng cao", 4));
	}

	@PostMapping("/subjects")
	public Subject create(@RequestBody Subject user) {
		subjects.add(user);

		return user;
	}

	@GetMapping("/subjects")
	public List<Subject> getAll() {
		return subjects;
	}
	
	@DeleteMapping("/subjects/{idSubject}") 
	public void delete(@RequestParam(name="idSubject", required = false,defaultValue = "") String idSubject) {
		for (int i = 0; i < subjects.size() ; i++) {
			if (subjects.get(i).getIdSubject().equals(idSubject)) {
				subjects.remove(i);
				break;
			}
		}
	}
	
	@PutMapping("/subjects/{idSubject}")
	public void update(@RequestBody Subject user) {
		for (int i = 0; i < subjects.size() ; i++) {
			if (subjects.get(i).getIdSubject().equals(user.getIdSubject())) {
				subjects.set(i, user);
				break;
			}
		}
	}
	
}