package Taskify.Task.Manager;

import Taskify.Task.Manager.Entity.Task;
import Taskify.Task.Manager.Repository.TaskRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class TaskManagerApplicationTests {

	@Autowired
	private TaskRepository taskRepository;

	@Test
	void testCreateTask() {
		Task task = new Task();
		task.setTitle("Write Unit Tests");
		task.setDescription("Write and test all unit test cases for the Task entity.");
		task.setDueDate(LocalDate.of(2024, 11, 20));
		task.setStatus(Task.Status.PENDING);

		Task savedTask = taskRepository.save(task);

		assertNotNull(savedTask.getId());
		assertEquals("Write Unit Tests", savedTask.getTitle());
	}

	@Test
	void testFindTaskById() {
		Task task = new Task();
		task.setTitle("Find Task");
		task.setDescription("Test the findById method.");
		task.setDueDate(LocalDate.of(2024, 11, 22));
		task.setStatus(Task.Status.PENDING);

		Task savedTask = taskRepository.save(task);
		Task foundTask = taskRepository.findById(savedTask.getId()).orElse(null);

		assertNotNull(foundTask);
		assertEquals(savedTask.getTitle(), foundTask.getTitle());
	}
}
