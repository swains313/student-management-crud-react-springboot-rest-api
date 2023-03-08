package net.javaguides.sms;



import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class StudentManagementSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudentManagementSystemApplication.class, args);
		
	}

//	implements CommandLineRunner
//	@Autowired
//	private StudentRepository studentRepository;
//	
//	@Override
//	public void run(String... args) throws Exception {
//		
//		Student s1=new Student("saumya","ranjan","swain@gmail.com");
//		studentRepository.save(s1);
//		
////		Student s2=new Student("saumya","ranjan","swain@gmail.com");
////		studentRepository.save(s2);
////		
////		Student s3=new Student("saumya","ranjan","swain@gmail.com");
////		studentRepository.save(s3);
//		
//		
//	}

}
